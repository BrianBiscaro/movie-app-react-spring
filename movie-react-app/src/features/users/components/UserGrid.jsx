import UserCard from "./UserCard";
import styles from './UserGrid.module.css'

export function UserGrid({ users }) {

    return (
        <div className={styles.usersGrid}>
            {users.map(
                user =>
                    <UserCard
                        user={user}
                        key={user.id}
                    />
            )}
        </div>
    )
}