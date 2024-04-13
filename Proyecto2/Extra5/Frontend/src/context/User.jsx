import { createContext, useContext, useState } from "react";

export const UserContext = createContext();

export const useUser = () => useContext(UserContext);

const UserProvider = ({ children }) => {
    const [user, setUser] = useState(JSON.parse(localStorage.getItem('user'))|| null);

    const actualizarUsuario = (user) => {
        if(user === null) {
            localStorage.removeItem('user')
            return
        };
        setUser(user);
        localStorage.setItem('user', JSON.stringify(user));
    }

    return (
        <UserContext.Provider value={{ user, actualizarUsuario }}>
            {children}
        </UserContext.Provider>
    );
}

export default UserProvider;