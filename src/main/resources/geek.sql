--
-- PostgreSQL database dump
--

-- Dumped from database version 12.6 (Ubuntu 12.6-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.6 (Ubuntu 12.6-0ubuntu0.20.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: hardware; Type: TABLE; Schema: public; Owner: geek
--

CREATE TABLE public.hardware (
    id integer NOT NULL,
    title character varying(50) NOT NULL,
    thread character varying(10) NOT NULL,
    length integer NOT NULL,
    note character varying(50)
);


ALTER TABLE public.hardware OWNER TO geek;

--
-- Name: hardware_id_seq; Type: SEQUENCE; Schema: public; Owner: geek
--

CREATE SEQUENCE public.hardware_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hardware_id_seq OWNER TO geek;

--
-- Name: hardware_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: geek
--

ALTER SEQUENCE public.hardware_id_seq OWNED BY public.hardware.id;


--
-- Name: hardware id; Type: DEFAULT; Schema: public; Owner: geek
--

ALTER TABLE ONLY public.hardware ALTER COLUMN id SET DEFAULT nextval('public.hardware_id_seq'::regclass);


--
-- Data for Name: hardware; Type: TABLE DATA; Schema: public; Owner: geek
--

COPY public.hardware (id, title, thread, length, note) FROM stdin;
1	Болт	M8	70	ржавый
3	Болтик	М6	45	нержавейка
\.


--
-- Name: hardware_id_seq; Type: SEQUENCE SET; Schema: public; Owner: geek
--

SELECT pg_catalog.setval('public.hardware_id_seq', 3, true);


--
-- Name: hardware hardware_pkey; Type: CONSTRAINT; Schema: public; Owner: geek
--

ALTER TABLE ONLY public.hardware
    ADD CONSTRAINT hardware_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

