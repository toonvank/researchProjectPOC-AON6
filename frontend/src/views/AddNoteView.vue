<template>
  <main class="flex flex-col items-center justify-center h-screen bg-gray-50 dark:bg-gray-900">
    <div class="w-full max-w-3xl px-4 md:px-6">
      <div class="space-y-6">
        <div class="flex flex-col items-center">
          <input
              class="flex h-10 rounded-md border border-input px-3 py-2 ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 text-3xl font-bold text-center w-full bg-transparent border-none focus:ring-0 dark:text-gray-100"
              placeholder="Title your note..."
              type="text"
          />
        </div>
        <textarea
            class="flex min-h-[80px] rounded-md border border-input px-3 py-2 ring-offset-background placeholder:text-muted-foreground focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 w-full h-[70vh] text-lg resize-none bg-transparent border-none focus:ring-0 dark:text-gray-100"
            placeholder="Start writing your note..."
        ></textarea>
        <div class="flex justify-between">
          <button @click="saveNote" class="inline-flex items-center justify-center whitespace-nowrap rounded-md text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-primary text-white w-36 h-10 hover:bg-opacity-90">
            Save
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

export default {
  data(){
    const store = notesStore();
    return{
      store
    }
  },
  methods: {
    saveNote() {
      this.store.saveNewNote(
          document.querySelector('input').value,
          document.querySelector('textarea').value
      );
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
