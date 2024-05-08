<script>
import { notesStore } from "@/store/modules/notes.js";
import { useRoute } from "vue-router";
import Swal from 'sweetalert2';
import { Filesystem, Directory, Encoding } from '@capacitor/filesystem';

export default {
  data() {
    const store = notesStore();
    let noteId;
    return {
      store,
      uploadedImage: null,
      note: {
        title: '',
        content: '',
        isEditing: false
      },
      noteId
    }
  },
  async mounted() {
    this.noteId = useRoute().params.id
    if (this.noteId) {
      await this.store.fetchNote(this.noteId)
      this.note = this.store.note
      this.note.isEditing = true
    }
  },
  methods: {
    async saveNote() {
      if (this.noteId) {
        this.store.updateNote(this.noteId, this.note.title, this.note.content, this.store.photo_url)
      } else {
        this.store.saveNewNote(this.note.title, this.note.content, this.store.photo_url)
      }
      if (this.store.error) {
        this.showError(this.store.error);
      }
      else {
        await this.store.fetchNotes();
      }
    },
    async saveAndExit() {
      await this.saveNote();
      if (!this.store.error) this.$router.push('/');
      else this.showError(this.store.error);
    },
    async deleteNote() {
      if (this.noteId) {
        await this.store.deleteNote(this.noteId);
        await this.store.fetchNotes();
        this.$router.push('/');
      }
    },
    showError(message) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: message,
      });
    },
    async addPhoto() {
      Swal.fire({
        title: 'What do you want to do?',
        showDenyButton: true,
        confirmButtonText: `Upload a photo`,
        denyButtonText: `Use the camera`,
        imageUrl: "https://dav.toonvank.online/" + this.note.photo_url,
      }).then((result) => {
        if (result.isConfirmed) {
          // Upload a photo
          Swal.fire({
            title: 'Upload photo',
            input: 'file',
            inputAttributes: {
              accept: 'image/*',
              'aria-label': 'Upload your profile picture'
            },
            showCancelButton: true,
            confirmButtonText: 'Upload',
            showLoaderOnConfirm: true,
            preConfirm: async (file) => {
              const reader = new FileReader();
              reader.readAsDataURL(file);
              reader.onload = async () => {
                this.store.photo_url = reader.result;
                this.store.photoTaken = true;
                // Write photo to the filesystem
                await this.writePhotoToFileSystem(reader.result);
              }
            },
            allowOutsideClick: () => !Swal.isLoading(),
          });
        } else if (result.isDenied) {
          // Use the camera
          this.$router.push('/camera');
        }
      });
    },
    async writePhotoToFileSystem(imageData) {
      try {
        // Create a file with a unique name (using timestamp) in the Documents directory
        const fileName = `photo_${Date.now()}.jpg`;
        const filePath = `${Directory.Documents}/${fileName}`;

        // Write image data to the file
        await Filesystem.writeFile({
          path: filePath,
          data: imageData,
          directory: Directory.Documents,
          encoding: Encoding.DataUrl
        });

        console.log('Photo saved to filesystem:', filePath);
      } catch (error) {
        console.error('Error saving photo to filesystem:', error);
      }
    }
  }
}
</script>
