import React from 'react';
import {createRoot} from "react-dom/client";
import App from './App.jsx'
import './styles/style.css';
import {BrowserRouter} from "react-router-dom";
import {OrderProvider} from "./context/OrderContext.jsx";

const root = createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter>
        <OrderProvider>
            <App/>
        </OrderProvider>
    </BrowserRouter>
);
