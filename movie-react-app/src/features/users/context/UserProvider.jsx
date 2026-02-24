import { useEffect, useState } from "react";
import { getUsers } from "../services/"

export const UserProvider = ({ children }) => {

    const [users, setUsers] = useState(() => {
        const storedUsers = localStorage.getItem("users")
        return storedUsers ? JSON.parse(storedUsers) : []
    });

    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        localStorage.setItem('users', JSON.stringify(users))
    }, [users])

    useEffect(() => {
        const loadUsers = async () => {

            try {
                const allUsers = await getUsers()
                setUsers(allUsers)
            } catch (err) {
                console.log(err)
                setError("Failed to load users")
            } finally {
                setLoading(false)
            }
        }

        loadUsers()
    }, [])

    const value = {
        users,
        setUsers,
        error,
        setError,
        loading,
        setLoading
    }



    return <UserContext.Provider value={value}>
        {children}
    </UserContext.Provider>
}