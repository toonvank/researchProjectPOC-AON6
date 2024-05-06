import { defineStore } from 'pinia';
import axios from 'axios';

const url = "https://pocapi.toonvank.online/api/notes/";

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
            try {
                const response = await axios.get(`${url}${id}`);
                this.note = response.data;
                this.loaded = true;
            } catch (error) {
                this.error = error.message;
            }
        },
        saveNewNote(title, content) {
            this.error = '';
            if (!title || !content) {
                this.error = "Title and content cannot be empty.";
                return;
            }
            axios.post(`${url}`, { title, content }, {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
                .then((response) => {
                    if (response.status === 201) {
                        return response.data;
                    } else {
                        throw new Error(`Error with status ${response.status}`);
                    }
                })
                .then((note) => {
                    this.notes.push(note);
                })
                .catch((error) => {
                    this.error = error.message;
                });
        },
        updateNote(id, title, content) {
            this.error = '';
            if (!title || !content) {
                this.error = "Title and content cannot be empty.";
                return;
            }
            const note = { title, content };
            axios.put(`${url}${id}`, note)
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
            axios.delete(`${url}${id}`)
                .then(response => {
                    this.notes = this.notes.filter(note => note.id !== id);
                })
                .catch(error => {
                    this.error = error.message;
                });
        }
    }
});
