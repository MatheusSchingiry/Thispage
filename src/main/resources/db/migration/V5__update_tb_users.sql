ALTER TABLE tb_users
    ADD COLUMN credentials_id UUID UNIQUE;

ALTER TABLE tb_users
    ADD CONSTRAINT fk_user_credentials
        FOREIGN KEY (credentials_id) REFERENCES tb_credentials(id)
            ON DELETE CASCADE;