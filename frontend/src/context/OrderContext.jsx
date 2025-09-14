import { createContext, useState } from "react";

export const OrderContext = createContext();

export function OrderProvider({ children }) {
    const [order, setOrder] = useState([]);

    function addToOrder(book) {
        setOrder((prev) => [...prev, book]);
    }

    return (
        <OrderContext.Provider value={{ order, addToOrder }}>
            {children}
        </OrderContext.Provider>
    );
}
