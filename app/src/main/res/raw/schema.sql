CREATE TABLE "regions"(
  "id" INTEGER CONSTRAINT "pk_regions" PRIMARY KEY AUTOINCREMENT,
  "name" VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE "countries"(
  "id" INTEGER CONSTRAINT "pk_countries" PRIMARY KEY AUTOINCREMENT,
  "name" VARCHAR(100) UNIQUE NOT NULL,
  "region_id" INTEGER NOT NULL REFERENCES "regions"("id"),
  "image_path" VARCHAR(256) UNIQUE NOT NULL
);

CREATE INDEX "idx_countries__region" ON "countries"("region_id");

CREATE TABLE "statistics"(
  "id" INTEGER CONSTRAINT "pk_statistics" PRIMARY KEY AUTOINCREMENT,
  "date_time" DATETIME UNIQUE NOT NULL,
  "num_questions" INTEGER NOT NULL,
  "num_attempts" INTEGER NOT NULL CHECK("num_attempts" >= "num_questions")
);
