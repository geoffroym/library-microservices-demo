import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig({
    plugins: [react()],
    server: {
        port: 5173, // change this to whatever port you want
        strictPort: true // throws an error if the port is already in use
    }
});




