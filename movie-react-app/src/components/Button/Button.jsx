import styles from "./Button.module.css";

export const Button = ({ children, onClick, type = 'button', variant = 'primary' }) => {
    return (
        <button
            type={type}
            className={`${styles.btn} ${styles[variant]}`}
            onClick={onClick}
        >
            {children}
        </button>
    )
}

