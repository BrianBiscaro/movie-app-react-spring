import { UserGrid } from '../features/users/components/UserGrid'
import { useUsersContext } from '../features/users/hooks/useUserContext'
import Footer from '../layouts/Footer'
import Header from '../layouts/Header'

const Users = () => {

    const { users, error, loading } = useUsersContext();

    return (
        <>
            <Header />
            <div className="users">

                {(error) && <div className='error-message'>{error}</div>}
                {(loading) ? <div> Loading... </div> : <UserGrid users={users} />}
            </div>
            <Footer />
        </>
    )
}

export default Users;