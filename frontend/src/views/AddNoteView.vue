<template>
  <main class="flex flex-col items-center justify-center h-screen bg-gray-50 dark:bg-gray-900">
    <div class="w-full max-w-3xl px-4 md:px-6">
      <div class="space-y-6">
        <div class="flex justify-between items-center">
          <input
              v-model="note.title"
              class="flex h-10 rounded-md border border-input px-3 py-2 ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 text-3xl font-bold text-center w-full bg-transparent border-none focus:ring-0 dark:text-gray-100"
              placeholder="Title your note..."
              type="text"
          />
          <button v-if="this.note.isEditing" @click="deleteNote" class="text-red-400 hover:text-red-600 focus:outline-none">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
              <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
              <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
            </svg>
          </button>
        </div>
        <textarea
            v-model="note.content"
            class="flex min-h-[80px] rounded-md border border-input px-3 py-2 ring-offset-background placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 w-full h-[70vh] text-lg resize-none bg-transparent border-none focus:ring-0 dark:text-gray-100"
            placeholder="Start writing your note..."
        ></textarea>
        <div class="flex justify-between">
          <button @click="$router.push('/')"
                  class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-white w-36 h-10 hover:bg-opacity-90">
            Cancel
          </button>
          <button @click="addPhoto" class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-white w-36 h-10 hover:bg-opacity-90">
            {{ this.note.photo_url || this.store.photo_url ? 'Update Photo' : 'Add Photo' }}
          </button>
          <button @click="saveAndExit" class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-white w-36 h-10 hover:bg-opacity-90">
            Save & Exit
          </button>
        </div>
      </div>
    </div>
  </main>
</template>



<script>
import {notesStore} from "@/store/modules/notes.js";
import {useRoute} from "vue-router";
import Swal from 'sweetalert2';

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
    console.log("https://dav.toonvank.online/images/" + this.note.photo_url)
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
    addPhoto() {
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
            preConfirm: (file) => {
              const reader = new FileReader();
              reader.readAsDataURL(file);
              reader.onload = () => {
                this.store.photo_url = reader.result;
                this.store.photoTaken = true;
              }
            },
            allowOutsideClick: () => !Swal.isLoading(),
          });
        } else if (result.isDenied) {
          // Use the camera
          this.$router.push('/camera');
        }
      });
    }
  }
}
</script>

<style scoped>
/* Add any custom styles here */
</style>
