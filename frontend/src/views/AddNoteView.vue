<template>
  <main class="flex flex-col items-center justify-center h-screen bg-gray-50 dark:bg-gray-900">
    <div class="w-full max-w-3xl px-4 md:px-6">
      <div class="space-y-6">
        <div class="flex flex-col items-center">
          <input
              v-model="note.title"
              class="flex h-10 rounded-md border border-input px-3 py-2 ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 text-3xl font-bold text-center w-full bg-transparent border-none focus:ring-0 dark:text-gray-100"
              placeholder="Title your note..."
              type="text"
          />
        </div>
        <textarea
            v-model="note.content"
            class="flex min-h-[80px] rounded-md border border-input px-3 py-2 ring-offset-background placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 w-full h-[70vh] text-lg resize-none bg-transparent border-none focus:ring-0 dark:text-gray-100"
            placeholder="Start writing your note..."
        ></textarea>
        <div class="flex justify-between">
          <button @click="saveNote" class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-white w-36 h-10 hover:bg-opacity-90">
            Save
          </button>
          <button @click="$router.push('/')"
              class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-white w-36 h-10 hover:bg-opacity-90">
            Cancel
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

export default {
  data() {
    const store = notesStore();
    let noteId;
    return {
      store,
      note: {
        title: '',
        content: ''
      },
      noteId
    }
  },
  async mounted() {
    this.noteId = useRoute().params.id
    if (this.noteId) {
      await this.store.fetchNote(this.noteId)
      this.note = this.store.note
    }
  },
  methods: {
    async saveNote() {
      if (this.noteId) {
        this.store.updateNote(this.noteId, this.note.title, this.note.content)
      } else {
        this.store.saveNewNote(this.note.title, this.note.content)
      }
      await this.store.fetchNotes();
    },
    saveAndExit() {
      this.saveNote();
      this.$router.push('/');
    }
  }
};
</script>

<style scoped>
/* Add any custom styles here */
</style>
