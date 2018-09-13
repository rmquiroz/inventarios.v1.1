--
-- PostgreSQL database dump
--


SET statement_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 1856 (class 1262 OID 65539)
-- Name: db_adendas; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE db_adendas WITH TEMPLATE = template0 ENCODING = 'WIN1252' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';


ALTER DATABASE db_adendas OWNER TO postgres;

\connect db_adendas

SET statement_timeout = 0;
SET client_encoding = 'WIN1252';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 1857 (class 1262 OID 65539)
-- Dependencies: 1856
-- Name: db_adendas; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE db_adendas IS 'Base de Datos de Adendas - FE';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 148 (class 1259 OID 106526)
-- Dependencies: 3
-- Name: c_clientes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE c_clientes (
    id_cliente integer NOT NULL,
    id_ob3 character varying(32),
    nombre_cliente character varying(50)
);


ALTER TABLE public.c_clientes OWNER TO postgres;

--
-- TOC entry 149 (class 1259 OID 106529)
-- Dependencies: 3
-- Name: c_organizacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE c_organizacion (
    id_org integer NOT NULL,
    id_ob3 character varying(32),
    name_org character varying(50)
);


ALTER TABLE public.c_organizacion OWNER TO postgres;

--
-- TOC entry 140 (class 1259 OID 65545)
-- Dependencies: 3
-- Name: encabezado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE encabezado_seq
    START WITH 258
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.encabezado_seq OWNER TO postgres;

--
-- TOC entry 146 (class 1259 OID 98346)
-- Dependencies: 3
-- Name: fedetalle_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE fedetalle_seq
    START WITH 258
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.fedetalle_seq OWNER TO postgres;

--
-- TOC entry 147 (class 1259 OID 98348)
-- Dependencies: 1823 3
-- Name: fe_detalle; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fe_detalle (
    id_fe_detalle integer DEFAULT nextval('fedetalle_seq'::regclass) NOT NULL,
    ob3id character varying(32) NOT NULL,
    ean_o_upc character varying(15),
    dun_14 character varying(14),
    descripcion character varying(100) NOT NULL,
    descripcion2 character varying(100),
    cantidad character varying(10) NOT NULL,
    unidad_de_medida character varying(10) NOT NULL,
    cant_empaque character varying(5),
    precio character varying(20) NOT NULL,
    porcen_desc_1 character varying(3),
    tipo_descuento_1 character varying(5),
    monto_de_descuento_1 character varying(20),
    porcen_descuento_2 character varying(3),
    tipo_descuento_2 character varying(5),
    monto_de_descuento_2 character varying(20),
    porcen_descuento_3 character varying(3),
    tipo_descuento_3 character varying(5),
    monto_de_descuento_3 character varying(20),
    porcen_descuento_4 character varying(3),
    tipo_descuento_4 character varying(5),
    monto_de_descuento_4 character varying(20),
    porcen_descuento_5 character varying(3),
    tipo_descuento_5 character varying(5),
    monto_de_descuento_5 character varying(20),
    precio_neto character varying(20) NOT NULL,
    porcen_iva character varying(3) NOT NULL,
    porcen_ieps character varying(3),
    cant_embarcada character varying(5),
    aduana character varying(10),
    fecha character varying(10),
    numero_pedimento character varying(8),
    numero_interno_de_pr1 character varying(20),
    numero_interno_de_pr2 character varying(20),
    cantidad_gratis_de_m character varying(5),
    tipo_de_empaque character varying(5),
    pago_de_empaque character varying(10),
    costo_total_precio character varying(20) NOT NULL,
    importe_con_descuen character varying(20),
    monto_de_iva character varying(20) NOT NULL,
    monto_de_ieps character varying(20),
    porcen_isr character varying(3),
    monto_isr character varying(20),
    porcen_impuesto_de_petrol character varying(3),
    monto_impuesto_de_pe character varying(20),
    porcen_exento character varying(3),
    monto_exento character varying(20),
    porcen_estatal character varying(3),
    monto_estatal character varying(20),
    porcen_cedular character varying(3),
    monto_cedular character varying(20),
    porcen_municipal character varying(3),
    monto_municipal character varying(20),
    porcen_hospedaje character varying(3),
    monto_hospedaje character varying(20),
    porcen_otros_impuestos character varying(3),
    monto_otros_impuesto character varying(20),
    orden_de_compra character varying(3),
    numero_de_cuenta_pre character varying(20),
    cantidad_real_de_kil character varying(10),
    cantidad_minima_a_surtir character varying(10),
    etiqueta_1 character varying(100),
    etiqueta_2 character varying(100),
    etiqueta_3 character varying(100),
    etiqueta_4 character varying(100),
    etiqueta_5 character varying(100),
    etiqueta_6 character varying(100),
    etiqueta_7 character varying(100),
    etiqueta_8 character varying(100),
    etiqueta_9 character varying(100),
    etiqueta_10 character varying(100),
    etiqueta_11 character varying(100),
    etiqueta_12 character varying(100),
    etiqueta_13 character varying(100),
    texto_libre_1 character varying(250),
    texto_libre_2 character varying(250)
);


ALTER TABLE public.fe_detalle OWNER TO postgres;

--
-- TOC entry 144 (class 1259 OID 98329)
-- Dependencies: 3
-- Name: fe_dir_fiscal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fe_dir_fiscal (
    ob3id character varying(32) NOT NULL,
    nombre_emisor_vende character varying(100) NOT NULL,
    rfc character varying(15) NOT NULL,
    gln character varying(20),
    calle character varying(100) NOT NULL,
    no_exterior character varying(60),
    no_interior character varying(60),
    colonia character varying(100),
    localidad character varying(100),
    referencia character varying(100),
    municipio character varying(60) NOT NULL,
    estado character varying(60) NOT NULL,
    pais character varying(50) NOT NULL,
    cp character varying(12) NOT NULL,
    regimen_fiscal_del_emisor character varying(50) NOT NULL,
    telefono character varying(15),
    etiqueta_1 character varying(100),
    etiqueta_2 character varying(100),
    etiqueta_3 character varying(100),
    etiqueta_4 character varying(100),
    etiqueta_5 character varying(100),
    etiqueta_6 character varying(100),
    etiqueta_7 character varying(100),
    etiqueta_8 character varying(100),
    no_de_cuenta character varying(100),
    etiqueta_10 character varying(100),
    etiqueta_11 character varying(100)
);


ALTER TABLE public.fe_dir_fiscal OWNER TO postgres;

--
-- TOC entry 145 (class 1259 OID 98334)
-- Dependencies: 3
-- Name: fe_dir_receptor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fe_dir_receptor (
    ob3id character varying(32) NOT NULL,
    nombre_receptor_cliente character varying(100) NOT NULL,
    rfc character varying(15) NOT NULL,
    gln character varying(20),
    calle character varying(100),
    no_exterior character varying(80),
    no_interior character varying(80),
    colonia character varying(100),
    localidad character varying(100),
    referencia character varying(100),
    municipio character varying(100),
    estado character varying(80),
    pais character varying(60) NOT NULL,
    cp character varying(8),
    imss character varying(16),
    telefono character varying(15),
    etiqueta_1 character varying(100),
    etiqueta_2 character varying(100),
    etiqueta_3 character varying(100),
    etiqueta_4 character varying(100),
    etiqueta_5 character varying(100),
    etiqueta_6 character varying(100),
    etiqueta_7 character varying(100),
    etiqueta_8 character varying(100),
    etiqueta_9 character varying(100)
);


ALTER TABLE public.fe_dir_receptor OWNER TO postgres;

--
-- TOC entry 151 (class 1259 OID 138725)
-- Dependencies: 3
-- Name: fe_encabezado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fe_encabezado (
    ob3id character varying(32) NOT NULL,
    serie character varying(30),
    folio character varying(30),
    no_aprobacion character varying(30),
    fecha_cfd character varying(20) NOT NULL,
    referencia_de_docume character varying(30),
    fecha_referencia_de character varying(20),
    forma_de_pago character varying(50) NOT NULL,
    dias_de_pago character varying(50),
    funcion character varying(50) NOT NULL,
    tipo_de_documento character varying(50) NOT NULL,
    porcen_descuento_1 character varying(20),
    tipo_descuento_1 character varying(30),
    monto_de_descuento1 character varying(20),
    porcen_descuento_2 character varying(20),
    tipo_descuento_2 character varying(30),
    monto_de_descuento_2 character varying(20),
    porcen_descuento_3 character varying(20),
    tipo_descuento_3 character varying(30),
    monto_de_descuento_3 character varying(20),
    anio_aprobacion character varying(5),
    numero_interno character varying(20),
    area_interna character varying(30),
    representante_legal character varying(100),
    no_proveedor character varying(20),
    tasa_global_de_iva character varying(20) NOT NULL,
    numero_de_tienda character varying(20),
    frm character varying(30),
    fecha_de_frm character varying(20),
    lugar_de_expedicion character varying(50) NOT NULL,
    metodo_de_pago character varying(50) NOT NULL,
    moneda character varying(5),
    tipo_de_cambio character varying(20),
    fecha_de_entrega_act character varying(20),
    contacto_de_compras character varying(100),
    departamento_del_con character varying(100),
    observaciones_1come character varying(250),
    observaciones_2come character varying(250),
    observaciones_3come character varying(250),
    observaciones_4come character varying(250),
    observaciones_5come character varying(250),
    no_aviso_anticipado character varying(20),
    fecha_aviso_anticipa character varying(20),
    importe_con_letra character varying(250) NOT NULL,
    tipo_impresion character varying(20),
    tipo_de_envio character varying(20),
    codigo_ieps character varying(20),
    etiqueta_1 character varying(100),
    etiqueta_2 character varying(100),
    etiqueta_3 character varying(100),
    etiqueta_4 character varying(100),
    etiqueta_5 character varying(100),
    etiqueta_6 character varying(100),
    cliid character varying(100)
);


ALTER TABLE public.fe_encabezado OWNER TO postgres;

--
-- TOC entry 141 (class 1259 OID 98314)
-- Dependencies: 3
-- Name: fe_expedido_en; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fe_expedido_en (
    ob3id character varying(32) NOT NULL,
    nombre_receptor character varying(100),
    rfc character varying(15),
    gln character varying(20),
    calle character varying(100),
    no_exterior character varying(100),
    no_interior character varying(100),
    colonia character varying(100),
    localidad character varying(100),
    referencia character varying(100),
    municipio character varying(80),
    estado character varying(80),
    pais character varying(80),
    cp character varying(8),
    imss character varying(16),
    telefono character varying(15),
    etiqueta_1 character varying(100),
    etiqueta_2 character varying(100),
    etiqueta_3 character varying(100),
    etiqueta_4 character varying(100),
    etiqueta_5 character varying(100),
    etiqueta_6 character varying(100),
    etiqueta_7 character varying(100),
    etiqueta_8 character varying(100),
    etiqueta_9 character varying(100),
    etiqueta_10 character varying(100)
);


ALTER TABLE public.fe_expedido_en OWNER TO postgres;

--
-- TOC entry 142 (class 1259 OID 98319)
-- Dependencies: 3
-- Name: fe_lugar_entrega; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fe_lugar_entrega (
    ob3id character varying(32) NOT NULL,
    nmbre_lugar_de_entre character varying(100),
    rfc character varying(15),
    gln character varying(20),
    calle character varying(150),
    no_exterior character varying(80),
    no_interior character varying(80),
    colonia character varying(100),
    localidad character varying(100),
    referencia character varying(100),
    municipio character varying(100),
    estado character varying(100),
    pais character varying(100),
    cp character varying(8),
    imss character varying(16),
    telefono character varying(15),
    etiqueta_1 character varying(100),
    etiqueta_2 character varying(100),
    etiqueta_3 character varying(100),
    etiqueta_4 character varying(100),
    etiqueta_5 character varying(100),
    etiqueta_6 character varying(100),
    etiqueta_7 character varying(100),
    etiqueta_8 character varying(100),
    etiqueta_9 character varying(100),
    etiqueta_10 character varying(100)
);


ALTER TABLE public.fe_lugar_entrega OWNER TO postgres;

--
-- TOC entry 143 (class 1259 OID 98324)
-- Dependencies: 3
-- Name: fe_sumario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fe_sumario (
    ob3id character varying(32) NOT NULL,
    subtotal character varying(20) NOT NULL,
    monto_descuento_1 character varying(20),
    monto_descuento_2 character varying(20),
    monto_descuento_3 character varying(20),
    monto_descuento_4 character varying(20),
    monto_descuento_5 character varying(20),
    iva character varying(20) NOT NULL,
    ieps character varying(20),
    total character varying(20) NOT NULL,
    subtotal_2 character varying(20),
    total_de_articulos_f character varying(10),
    porcen_iva character varying(3) NOT NULL,
    porcen_ieps character varying(3),
    porcen_isr character varying(3),
    monto_isr character varying(20),
    porcen_impuesto_de_petrol character varying(3),
    monto_impuesto_de_pe character varying(20),
    porcen_exento character varying(3),
    monto_exento character varying(20),
    porcen_estatal character varying(3),
    monto_estatal character varying(20),
    porcen_cedular character varying(3),
    monto_cedular character varying(20),
    porcen_municipal character varying(3),
    monto_municipal character varying(20),
    porcen_hospedaje character varying(3),
    monto_hospedaje character varying(20),
    porcen_otros_impuestos character varying(3),
    monto_otros_impuesto character varying(20),
    numero_de_partidas character varying(3),
    porcen_iva_retenido character varying(20),
    monto_de_iva_retenid character varying(3),
    porcen_isr_retenido character varying(20),
    monto_de_isr_retenid character varying(3),
    monto_total_de_descu character varying(20),
    subtotal_3 character varying(20) NOT NULL,
    subtotal_4 character varying(20),
    etiqueta_1 character varying(100),
    etiqueta_2 character varying(100)
);


ALTER TABLE public.fe_sumario OWNER TO postgres;

--
-- TOC entry 150 (class 1259 OID 106532)
-- Dependencies: 149 3
-- Name: organizacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE organizacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.organizacion_seq OWNER TO postgres;

--
-- TOC entry 1860 (class 0 OID 0)
-- Dependencies: 150
-- Name: organizacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE organizacion_seq OWNED BY c_organizacion.id_org;


--
-- TOC entry 154 (class 1259 OID 204323)
-- Dependencies: 3
-- Name: perfil; Type: TABLE; Schema: public; Owner: Desarrollo; Tablespace: 
--

CREATE TABLE perfil (
    authority character(30) NOT NULL,
    username character varying(30) NOT NULL
);


ALTER TABLE public.perfil OWNER TO "Desarrollo";

--
-- TOC entry 153 (class 1259 OID 196138)
-- Dependencies: 1825 1826 1827 1828 3
-- Name: usuario; Type: TABLE; Schema: public; Owner: Desarrollo; Tablespace: 
--

CREATE TABLE usuario (
    nombre character varying(80),
    apellido_paterno character varying(80) NOT NULL,
    apellido_materno character varying(80),
    accountnonexpired boolean DEFAULT false NOT NULL,
    accountnonlocked boolean DEFAULT false NOT NULL,
    credentialsnonexpired boolean DEFAULT false NOT NULL,
    enabled boolean DEFAULT false NOT NULL,
    password character varying(32) NOT NULL,
    username character varying(30) NOT NULL
);


ALTER TABLE public.usuario OWNER TO "Desarrollo";

--
-- TOC entry 152 (class 1259 OID 163363)
-- Dependencies: 3
-- Name: usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_seq
    START WITH 376
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.usuario_seq OWNER TO postgres;

--
-- TOC entry 1824 (class 2604 OID 106534)
-- Dependencies: 150 149
-- Name: id_org; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY c_organizacion ALTER COLUMN id_org SET DEFAULT nextval('organizacion_seq'::regclass);


--
-- TOC entry 1842 (class 2606 OID 106536)
-- Dependencies: 148 148
-- Name: c_clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY c_clientes
    ADD CONSTRAINT c_clientes_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 1844 (class 2606 OID 106538)
-- Dependencies: 149 149
-- Name: c_organizacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY c_organizacion
    ADD CONSTRAINT c_organizacion_pkey PRIMARY KEY (id_org);


--
-- TOC entry 1840 (class 2606 OID 98356)
-- Dependencies: 147 147
-- Name: pk_ddetalle; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fe_detalle
    ADD CONSTRAINT pk_ddetalle PRIMARY KEY (id_fe_detalle);


--
-- TOC entry 1836 (class 2606 OID 98333)
-- Dependencies: 144 144
-- Name: pk_dir_fis; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fe_dir_fiscal
    ADD CONSTRAINT pk_dir_fis PRIMARY KEY (ob3id);


--
-- TOC entry 1838 (class 2606 OID 98338)
-- Dependencies: 145 145
-- Name: pk_dir_rep; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fe_dir_receptor
    ADD CONSTRAINT pk_dir_rep PRIMARY KEY (ob3id);


--
-- TOC entry 1846 (class 2606 OID 138732)
-- Dependencies: 151 151
-- Name: pk_encabezado; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fe_encabezado
    ADD CONSTRAINT pk_encabezado PRIMARY KEY (ob3id);


--
-- TOC entry 1830 (class 2606 OID 98318)
-- Dependencies: 141 141
-- Name: pk_exp_en; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fe_expedido_en
    ADD CONSTRAINT pk_exp_en PRIMARY KEY (ob3id);


--
-- TOC entry 1832 (class 2606 OID 98323)
-- Dependencies: 142 142
-- Name: pk_lug_ent; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fe_lugar_entrega
    ADD CONSTRAINT pk_lug_ent PRIMARY KEY (ob3id);


--
-- TOC entry 1852 (class 2606 OID 237106)
-- Dependencies: 154 154 154
-- Name: pk_perf_u; Type: CONSTRAINT; Schema: public; Owner: Desarrollo; Tablespace: 
--

ALTER TABLE ONLY perfil
    ADD CONSTRAINT pk_perf_u PRIMARY KEY (authority, username);


--
-- TOC entry 1834 (class 2606 OID 98328)
-- Dependencies: 143 143
-- Name: pk_sumario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fe_sumario
    ADD CONSTRAINT pk_sumario PRIMARY KEY (ob3id);


--
-- TOC entry 1848 (class 2606 OID 237092)
-- Dependencies: 153 153
-- Name: pk_usuario; Type: CONSTRAINT; Schema: public; Owner: Desarrollo; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT pk_usuario PRIMARY KEY (username);


--
-- TOC entry 1850 (class 2606 OID 237094)
-- Dependencies: 153 153
-- Name: u_usr; Type: CONSTRAINT; Schema: public; Owner: Desarrollo; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT u_usr UNIQUE (username);


--
-- TOC entry 1853 (class 2606 OID 237107)
-- Dependencies: 1847 153 154
-- Name: fk_usr; Type: FK CONSTRAINT; Schema: public; Owner: Desarrollo
--

ALTER TABLE ONLY perfil
    ADD CONSTRAINT fk_usr FOREIGN KEY (username) REFERENCES usuario(username);


--
-- TOC entry 1859 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: Desarrollo
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM "Desarrollo";
GRANT ALL ON SCHEMA public TO "Desarrollo";
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 1861 (class 0 OID 0)
-- Dependencies: 154
-- Name: perfil; Type: ACL; Schema: public; Owner: Desarrollo
--

REVOKE ALL ON TABLE perfil FROM PUBLIC;
REVOKE ALL ON TABLE perfil FROM "Desarrollo";
GRANT ALL ON TABLE perfil TO "Desarrollo";
GRANT ALL ON TABLE perfil TO PUBLIC;


--
-- TOC entry 1862 (class 0 OID 0)
-- Dependencies: 153
-- Name: usuario; Type: ACL; Schema: public; Owner: Desarrollo
--

REVOKE ALL ON TABLE usuario FROM PUBLIC;
REVOKE ALL ON TABLE usuario FROM "Desarrollo";
GRANT ALL ON TABLE usuario TO "Desarrollo";
GRANT ALL ON TABLE usuario TO PUBLIC;


-- Completed on 2015-02-15 22:54:17

--
-- PostgreSQL database dump complete
--

