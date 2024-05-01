<template>
  <div class="grid grid-cols-1 min-h-screen w-full bg-gradient-to-br from-gray-100 via-gray-200 to-gray-300 dark:from-gray-800 dark:via-gray-700 dark:to-gray-600">
    <div class="flex flex-col">
      <header class="flex h-14 items-center gap-4 border-b bg-white/40 px-4 dark:bg-black/40 md:h-[60px] md:px-6">
        <a class="md:hidden" href="#">
          <svg
              xmlns="http://www.w3.org/2000/svg"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              fill="none"
              stroke="currentColor"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
              class="h-6 w-6 text-gray-700 dark:text-gray-300"
          >
            <path d="m3 21 1.9-5.7a8.5 8.5 0 1 1 3.8 3.8z"></path>
          </svg>
          <span class="sr-only">MemoSphere</span>
        </a>
        <div class="w-full flex-1">
          <form>
            <div class="relative">
              <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="currentColor"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  class="absolute left-2.5 top-2.5 h-4 w-4 text-gray-500 dark:text-gray-400"
              >
                <circle cx="11" cy="11" r="8"></circle>
                <path d="m21 21-4.3-4.3"></path>
              </svg>
              <input
                  type="text"
                  placeholder="Search notes"
                  class="bg-transparent pl-10 pr-3 py-2 w-full rounded-md border border-transparent focus:ring-2 focus:ring-primary focus:ring-offset-background focus:outline-none dark:text-gray-100">
            </div>
          </form>
        </div>
      </header>
      <main class="flex-1 flex flex-col gap-4 p-4 md:gap-8 md:p-6">
        <div class="flex items-center">
          <h1 class="font-semibold text-lg md:text-2xl text-gray-800 dark:text-gray-200">Notes</h1>
          <button class="inline-flex items-center justify-center whitespace-nowrap text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 bg-blue-500 text-white hover:bg-blue-600 h-9 rounded-md px-3 ml-auto">
            <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                class="h-4 w-4 mr-2"
            >
              <path d="M5 12h14"></path>
              <path d="M12 5v14"></path>
            </svg>
            New Note
          </button>
        </div>
        <div class="grid grid-cols-1 gap-4 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
          <NoteCard v-for="(note, index) in notes" :key="index" :note="note" />
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import NoteCard from "@/components/NoteCard.vue";
import {notesStore} from "@/store/modules/notes";

export default {
  components: {NoteCard},
  data(){
    const store = notesStore();
    return{
      store
    }
  },
  computed: {
    loaded() {
      return this.store.loaded
    },
    notes() {
      return this.store.notes;
    },
  },
  async mounted() {
    await this.store.fetchNotes();
  }
};
</script>


<style>
/* Add any custom styles here */
</style>
