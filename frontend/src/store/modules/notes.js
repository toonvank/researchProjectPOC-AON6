import { defineStore } from 'pinia';
import axios from 'axios';
import Swal from 'sweetalert2';

const url = 'http://localhost:8080/api/notes';

export const notesStore = defineStore('notes', {
    state: () => ({
        notes: [],
        note: null,
        error: null,
        loaded: false
    }),
    actions: {
        async fetchNotes() {
            this.loaded = false;
            this.error = '';
            this.notes = [];
            try {
                const response = await axios.get(url);
                this.notes = response.data;
                this.loaded = true;
            } catch (error) {
                this.error = error.message;
            }
        },
        async fetchNote(id) {
            this.loaded = false;
            this.error = '';
            this.note = null;
            try {
                const response = await axios.get(`${url}/${id}`);
                this.note = response.data;
                this.loaded = true;
            } catch (error) {
                this.error = error.message;
            }
        },
        saveNewNote(title, content) {
            this.error = '';
            const note = { title, content };
            axios.post(`${url}/add`, note)
                .then(response => {
                    this.notes.push(response.data);
                })
                .catch(error => {
                    this.error = error.message;
                });
        },
        updateNote(id, title, content) {
            this.error = '';
            const note = { title, content };
            axios.put(`${url}/update/${id}`, note)
                .then(response => {
                    const index = this.notes.findIndex(note => note.id === id);
                    if (index !== -1) {
                        this.notes[index] = response.data;
                    }
                })
                .catch(error => {
                    this.error = error.message;
                });
        },
        deleteNote(id) {
            this.error = '';
            axios.delete(`${url}/delete/${id}`)
                .then(response => {
                    this.notes = this.notes.filter(note => note.id !== id);
                    Swal.fire({
                        icon: 'success',
                        title: 'Note deleted successfully',
                        showConfirmButton: false,
                        timer: 2000
                    });
                })
                .catch(error => {
                    this.error = error.message;
                });
        }
    }
});