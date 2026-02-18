ALTER TABLE tb_posts
    ADD COLUMN creator_id UUID;

ALTER TABLE tb_posts
    ADD CONSTRAINT fk_post_creator
        FOREIGN KEY (creator_id)
            REFERENCES tb_users(id)
            ON DELETE CASCADE;