import styles from "./UserCard.module.css"

const UserCard = ({ user }) => {

    return (
        <div className={styles.userCard}>
            <h2>{user.name}</h2>
            <p>{user.email}</p>
        </div>
    )
}

export default UserCard;