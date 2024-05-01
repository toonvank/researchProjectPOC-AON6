<template>
  <RouterLink :to="'add-note/'+note.id">
    <div class="rounded-lg border bg-gray-800 text-gray-300 shadow-sm relative group overflow-hidden" data-v0-t="card">
      <a class="absolute inset-0 z-10" href="#">
        <span class="sr-only">View note</span>
      </a>
      <div class="p-6 h-full">
        <div class="flex flex-col justify-between h-full">
          <div>
            <h3 class="text-lg font-semibold">{{ note.title }}</h3>
            <p class="line-clamp-3 text-sm text-gray-500 dark:text-gray-400">{{ note.content }}</p>
          </div>
          <div class="flex items-center justify-between mt-2">
            <div class="flex items-center gap-2 text-sm text-gray-500 dark:text-gray-400">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="h-4 w-4">
                <rect width="18" height="18" x="3" y="4" rx="2" ry="2"></rect>
                <line x1="16" x2="16" y1="2" y2="6"></line>
                <line x1="8" x2="8" y1="2" y2="6"></line>
                <line x1="3" x2="21" y1="10" y2="10"></line>
              </svg>
              <span>{{ formatDate(note.date) }}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </RouterLink>
</template>

<script>
export default {
  props: {
    note: {
      type: Object,
      required: true,
    },
  },
  methods: {
    formatDate(dateString) {
      const options = {year: 'numeric', month: 'long', day: 'numeric'};
      return new Date(dateString).toLocaleDateString('en-US', options);
    },
    deleteNote() {
      // Implement your delete logic here
      console.log('Deleting note:', this.note.id);
    }
  }
};
</script>

<style>
/* Add any custom styles here */
</style>
