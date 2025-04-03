DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'map_storage_db') THEN
        CREATE DATABASE map_storage_db;
    END IF;
END $$;
