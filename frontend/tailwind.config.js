/** @type {import('tailwindcss').Config} */
const colors = require('tailwindcss/colors');

module.exports = {
  content: [
    './src/**/*.{js, jsx, ts, tsx, mdx}'
  ],
  purge: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}'],
  theme: {
    extend: {
      colors: {
        lightBlue: colors.sky,
        white: colors.white,
        black: colors.black,
      },
    },
  }

};
