package mx.redts.ob3.model;

// Generated 03-jun-2014 0:22:34 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CInvoice generated by hbm2java
 */
@Entity
@Table(name = "c_invoice", schema = "public")
public class CInvoice implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CInvoiceId;
	private FinPaymentmethod finPaymentmethod;
	private AdOrg adOrgByAdOrgtrxId;
	private CDoctype CDoctypeByCDoctypetargetId;
	private AdOrg adOrgByAdOrgId;
	private CBpartnerLocation CBpartnerLocation;
	private CBpartner CBpartner;
	private CDoctype CDoctypeByCDoctypeId;
	private CPaymentterm CPaymentterm;
	private COrder COrder;
	private CCurrency CCurrency;
	private String adClientId;
	private char isactive;
	private Date created;
	private String createdby;
	private Date updated;
	private String updatedby;
	private char issotrx;
	private String documentno;
	private String docstatus;
	private String docaction;
	private Character processing;
	private char processed;
	private String posted;
	private String description;
	private char isprinted;
	private String salesrepId;
	private Date dateinvoiced;
	private Date dateprinted;
	private Date dateacct;
	private String poreference;
	private char isdiscountprinted;
	private Date dateordered;
	private String paymentrule;
	private String CChargeId;
	private BigDecimal chargeamt;
	private BigDecimal totallines;
	private BigDecimal grandtotal;
	private String MPricelistId;
	private Character istaxincluded;
	private String CCampaignId;
	private String CProjectId;
	private String CActivityId;
	private Character createfrom;
	private Character generateto;
	private String adUserId;
	private Character copyfrom;
	private char isselfservice;
	private String user1Id;
	private String user2Id;
	private BigDecimal withholdingamount;
	private Date taxdate;
	private String CWithholdingId;
	private char ispaid;
	private BigDecimal totalpaid;
	private BigDecimal outstandingamt;
	private BigDecimal daystilldue;
	private BigDecimal dueamt;
	private Date lastcalculatedondate;
	private char updatepaymentmonitor;
	private String finPaymentPriorityId;
	private Date finalsettlement;
	private BigDecimal daysoutstanding;
	private BigDecimal percentageoverdue;
	private String calculatePromotions;
	private Character emAprmAddpayment;
	private String emAprmProcessinvoice;
	private Set<CInvoicetax> CInvoicetaxes = new HashSet<CInvoicetax>(0);
	private Set<CInvoiceline> CInvoicelines = new HashSet<CInvoiceline>(0);

	public CInvoice() {
	}

	public CInvoice(String CInvoiceId, CDoctype CDoctypeByCDoctypetargetId,
			AdOrg adOrgByAdOrgId, CBpartnerLocation CBpartnerLocation,
			CBpartner CBpartner, CDoctype CDoctypeByCDoctypeId,
			CPaymentterm CPaymentterm, CCurrency CCurrency, String adClientId,
			char isactive, Date created, String createdby, Date updated,
			String updatedby, char issotrx, String documentno,
			String docstatus, String docaction, char processed, String posted,
			char isprinted, Date dateinvoiced, Date dateacct,
			char isdiscountprinted, BigDecimal totallines,
			BigDecimal grandtotal, String MPricelistId, char isselfservice,
			char ispaid, BigDecimal totalpaid, BigDecimal outstandingamt,
			BigDecimal daystilldue, BigDecimal dueamt, char updatepaymentmonitor) {
		this.CInvoiceId = CInvoiceId;
		this.CDoctypeByCDoctypetargetId = CDoctypeByCDoctypetargetId;
		this.adOrgByAdOrgId = adOrgByAdOrgId;
		this.CBpartnerLocation = CBpartnerLocation;
		this.CBpartner = CBpartner;
		this.CDoctypeByCDoctypeId = CDoctypeByCDoctypeId;
		this.CPaymentterm = CPaymentterm;
		this.CCurrency = CCurrency;
		this.adClientId = adClientId;
		this.isactive = isactive;
		this.created = created;
		this.createdby = createdby;
		this.updated = updated;
		this.updatedby = updatedby;
		this.issotrx = issotrx;
		this.documentno = documentno;
		this.docstatus = docstatus;
		this.docaction = docaction;
		this.processed = processed;
		this.posted = posted;
		this.isprinted = isprinted;
		this.dateinvoiced = dateinvoiced;
		this.dateacct = dateacct;
		this.isdiscountprinted = isdiscountprinted;
		this.totallines = totallines;
		this.grandtotal = grandtotal;
		this.MPricelistId = MPricelistId;
		this.isselfservice = isselfservice;
		this.ispaid = ispaid;
		this.totalpaid = totalpaid;
		this.outstandingamt = outstandingamt;
		this.daystilldue = daystilldue;
		this.dueamt = dueamt;
		this.updatepaymentmonitor = updatepaymentmonitor;
	}

	public CInvoice(String CInvoiceId, FinPaymentmethod finPaymentmethod,
			AdOrg adOrgByAdOrgtrxId, CDoctype CDoctypeByCDoctypetargetId,
			AdOrg adOrgByAdOrgId, CBpartnerLocation CBpartnerLocation,
			CBpartner CBpartner, CDoctype CDoctypeByCDoctypeId,
			CPaymentterm CPaymentterm, COrder COrder, CCurrency CCurrency,
			String adClientId, char isactive, Date created, String createdby,
			Date updated, String updatedby, char issotrx, String documentno,
			String docstatus, String docaction, Character processing,
			char processed, String posted, String description, char isprinted,
			String salesrepId, Date dateinvoiced, Date dateprinted,
			Date dateacct, String poreference, char isdiscountprinted,
			Date dateordered, String paymentrule, String CChargeId,
			BigDecimal chargeamt, BigDecimal totallines, BigDecimal grandtotal,
			String MPricelistId, Character istaxincluded, String CCampaignId,
			String CProjectId, String CActivityId, Character createfrom,
			Character generateto, String adUserId, Character copyfrom,
			char isselfservice, String user1Id, String user2Id,
			BigDecimal withholdingamount, Date taxdate, String CWithholdingId,
			char ispaid, BigDecimal totalpaid, BigDecimal outstandingamt,
			BigDecimal daystilldue, BigDecimal dueamt,
			Date lastcalculatedondate, char updatepaymentmonitor,
			String finPaymentPriorityId, Date finalsettlement,
			BigDecimal daysoutstanding, BigDecimal percentageoverdue,
			String calculatePromotions, Character emAprmAddpayment,
			String emAprmProcessinvoice, Set<CInvoicetax> CInvoicetaxes,
			Set<CInvoiceline> CInvoicelines) {
		this.CInvoiceId = CInvoiceId;
		this.finPaymentmethod = finPaymentmethod;
		this.adOrgByAdOrgtrxId = adOrgByAdOrgtrxId;
		this.CDoctypeByCDoctypetargetId = CDoctypeByCDoctypetargetId;
		this.adOrgByAdOrgId = adOrgByAdOrgId;
		this.CBpartnerLocation = CBpartnerLocation;
		this.CBpartner = CBpartner;
		this.CDoctypeByCDoctypeId = CDoctypeByCDoctypeId;
		this.CPaymentterm = CPaymentterm;
		this.COrder = COrder;
		this.CCurrency = CCurrency;
		this.adClientId = adClientId;
		this.isactive = isactive;
		this.created = created;
		this.createdby = createdby;
		this.updated = updated;
		this.updatedby = updatedby;
		this.issotrx = issotrx;
		this.documentno = documentno;
		this.docstatus = docstatus;
		this.docaction = docaction;
		this.processing = processing;
		this.processed = processed;
		this.posted = posted;
		this.description = description;
		this.isprinted = isprinted;
		this.salesrepId = salesrepId;
		this.dateinvoiced = dateinvoiced;
		this.dateprinted = dateprinted;
		this.dateacct = dateacct;
		this.poreference = poreference;
		this.isdiscountprinted = isdiscountprinted;
		this.dateordered = dateordered;
		this.paymentrule = paymentrule;
		this.CChargeId = CChargeId;
		this.chargeamt = chargeamt;
		this.totallines = totallines;
		this.grandtotal = grandtotal;
		this.MPricelistId = MPricelistId;
		this.istaxincluded = istaxincluded;
		this.CCampaignId = CCampaignId;
		this.CProjectId = CProjectId;
		this.CActivityId = CActivityId;
		this.createfrom = createfrom;
		this.generateto = generateto;
		this.adUserId = adUserId;
		this.copyfrom = copyfrom;
		this.isselfservice = isselfservice;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.withholdingamount = withholdingamount;
		this.taxdate = taxdate;
		this.CWithholdingId = CWithholdingId;
		this.ispaid = ispaid;
		this.totalpaid = totalpaid;
		this.outstandingamt = outstandingamt;
		this.daystilldue = daystilldue;
		this.dueamt = dueamt;
		this.lastcalculatedondate = lastcalculatedondate;
		this.updatepaymentmonitor = updatepaymentmonitor;
		this.finPaymentPriorityId = finPaymentPriorityId;
		this.finalsettlement = finalsettlement;
		this.daysoutstanding = daysoutstanding;
		this.percentageoverdue = percentageoverdue;
		this.calculatePromotions = calculatePromotions;
		this.emAprmAddpayment = emAprmAddpayment;
		this.emAprmProcessinvoice = emAprmProcessinvoice;
		this.CInvoicetaxes = CInvoicetaxes;
		this.CInvoicelines = CInvoicelines;
	}

	@Column(name = "ad_client_id", nullable = false, length = 32)
	public String getAdClientId() {
		return this.adClientId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ad_org_id", nullable = false)
	public AdOrg getAdOrgByAdOrgId() {
		return this.adOrgByAdOrgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ad_orgtrx_id")
	public AdOrg getAdOrgByAdOrgtrxId() {
		return this.adOrgByAdOrgtrxId;
	}

	@Column(name = "ad_user_id", length = 32)
	public String getAdUserId() {
		return this.adUserId;
	}

	@Column(name = "c_activity_id", length = 32)
	public String getCActivityId() {
		return this.CActivityId;
	}

	@Column(name = "calculate_promotions", length = 1)
	public String getCalculatePromotions() {
		return this.calculatePromotions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_bpartner_id", nullable = false)
	public CBpartner getCBpartner() {
		return this.CBpartner;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_bpartner_location_id", nullable = false)
	public CBpartnerLocation getCBpartnerLocation() {
		return this.CBpartnerLocation;
	}

	@Column(name = "c_campaign_id", length = 32)
	public String getCCampaignId() {
		return this.CCampaignId;
	}

	@Column(name = "c_charge_id", length = 32)
	public String getCChargeId() {
		return this.CChargeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_currency_id", nullable = false)
	public CCurrency getCCurrency() {
		return this.CCurrency;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_doctype_id", nullable = false)
	public CDoctype getCDoctypeByCDoctypeId() {
		return this.CDoctypeByCDoctypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_doctypetarget_id", nullable = false)
	public CDoctype getCDoctypeByCDoctypetargetId() {
		return this.CDoctypeByCDoctypetargetId;
	}

	@Column(name = "chargeamt", precision = 131089, scale = 0)
	public BigDecimal getChargeamt() {
		return this.chargeamt;
	}

	@Id
	@Column(name = "c_invoice_id", unique = true, nullable = false, length = 32)
	public String getCInvoiceId() {
		return this.CInvoiceId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CInvoice")
	public Set<CInvoiceline> getCInvoicelines() {
		return this.CInvoicelines;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CInvoice")
	public Set<CInvoicetax> getCInvoicetaxes() {
		return this.CInvoicetaxes;
	}

	@Column(name = "copyfrom", length = 1)
	public Character getCopyfrom() {
		return this.copyfrom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_order_id")
	public COrder getCOrder() {
		return this.COrder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_paymentterm_id", nullable = false)
	public CPaymentterm getCPaymentterm() {
		return this.CPaymentterm;
	}

	@Column(name = "c_project_id", length = 32)
	public String getCProjectId() {
		return this.CProjectId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 29)
	public Date getCreated() {
		return this.created;
	}

	@Column(name = "createdby", nullable = false, length = 32)
	public String getCreatedby() {
		return this.createdby;
	}

	@Column(name = "createfrom", length = 1)
	public Character getCreatefrom() {
		return this.createfrom;
	}

	@Column(name = "c_withholding_id", length = 32)
	public String getCWithholdingId() {
		return this.CWithholdingId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateacct", nullable = false, length = 29)
	public Date getDateacct() {
		return this.dateacct;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateinvoiced", nullable = false, length = 29)
	public Date getDateinvoiced() {
		return this.dateinvoiced;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateordered", length = 29)
	public Date getDateordered() {
		return this.dateordered;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateprinted", length = 29)
	public Date getDateprinted() {
		return this.dateprinted;
	}

	@Column(name = "daysoutstanding", precision = 131089, scale = 0)
	public BigDecimal getDaysoutstanding() {
		return this.daysoutstanding;
	}

	@Column(name = "daystilldue", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getDaystilldue() {
		return this.daystilldue;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	@Column(name = "docaction", nullable = false, length = 60)
	public String getDocaction() {
		return this.docaction;
	}

	@Column(name = "docstatus", nullable = false, length = 60)
	public String getDocstatus() {
		return this.docstatus;
	}

	@Column(name = "documentno", nullable = false, length = 30)
	public String getDocumentno() {
		return this.documentno;
	}

	@Column(name = "dueamt", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getDueamt() {
		return this.dueamt;
	}

	@Column(name = "em_aprm_addpayment", length = 1)
	public Character getEmAprmAddpayment() {
		return this.emAprmAddpayment;
	}

	@Column(name = "em_aprm_processinvoice", length = 60)
	public String getEmAprmProcessinvoice() {
		return this.emAprmProcessinvoice;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "finalsettlement", length = 29)
	public Date getFinalsettlement() {
		return this.finalsettlement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fin_paymentmethod_id")
	public FinPaymentmethod getFinPaymentmethod() {
		return this.finPaymentmethod;
	}

	@Column(name = "fin_payment_priority_id", length = 32)
	public String getFinPaymentPriorityId() {
		return this.finPaymentPriorityId;
	}

	@Column(name = "generateto", length = 1)
	public Character getGenerateto() {
		return this.generateto;
	}

	@Column(name = "grandtotal", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getGrandtotal() {
		return this.grandtotal;
	}

	@Column(name = "isactive", nullable = false, length = 1)
	public char getIsactive() {
		return this.isactive;
	}

	@Column(name = "isdiscountprinted", nullable = false, length = 1)
	public char getIsdiscountprinted() {
		return this.isdiscountprinted;
	}

	@Column(name = "ispaid", nullable = false, length = 1)
	public char getIspaid() {
		return this.ispaid;
	}

	@Column(name = "isprinted", nullable = false, length = 1)
	public char getIsprinted() {
		return this.isprinted;
	}

	@Column(name = "isselfservice", nullable = false, length = 1)
	public char getIsselfservice() {
		return this.isselfservice;
	}

	@Column(name = "issotrx", nullable = false, length = 1)
	public char getIssotrx() {
		return this.issotrx;
	}

	@Column(name = "istaxincluded", length = 1)
	public Character getIstaxincluded() {
		return this.istaxincluded;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastcalculatedondate", length = 29)
	public Date getLastcalculatedondate() {
		return this.lastcalculatedondate;
	}

	@Column(name = "m_pricelist_id", nullable = false, length = 32)
	public String getMPricelistId() {
		return this.MPricelistId;
	}

	@Column(name = "outstandingamt", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getOutstandingamt() {
		return this.outstandingamt;
	}

	@Column(name = "paymentrule", length = 60)
	public String getPaymentrule() {
		return this.paymentrule;
	}

	@Column(name = "percentageoverdue", precision = 131089, scale = 0)
	public BigDecimal getPercentageoverdue() {
		return this.percentageoverdue;
	}

	@Column(name = "poreference", length = 20)
	public String getPoreference() {
		return this.poreference;
	}

	@Column(name = "posted", nullable = false, length = 60)
	public String getPosted() {
		return this.posted;
	}

	@Column(name = "processed", nullable = false, length = 1)
	public char getProcessed() {
		return this.processed;
	}

	@Column(name = "processing", length = 1)
	public Character getProcessing() {
		return this.processing;
	}

	@Column(name = "salesrep_id", length = 32)
	public String getSalesrepId() {
		return this.salesrepId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "taxdate", length = 29)
	public Date getTaxdate() {
		return this.taxdate;
	}

	@Column(name = "totallines", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getTotallines() {
		return this.totallines;
	}

	@Column(name = "totalpaid", nullable = false, precision = 131089, scale = 0)
	public BigDecimal getTotalpaid() {
		return this.totalpaid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", nullable = false, length = 29)
	public Date getUpdated() {
		return this.updated;
	}

	@Column(name = "updatedby", nullable = false, length = 32)
	public String getUpdatedby() {
		return this.updatedby;
	}

	@Column(name = "updatepaymentmonitor", nullable = false, length = 1)
	public char getUpdatepaymentmonitor() {
		return this.updatepaymentmonitor;
	}

	@Column(name = "user1_id", length = 32)
	public String getUser1Id() {
		return this.user1Id;
	}

	@Column(name = "user2_id", length = 32)
	public String getUser2Id() {
		return this.user2Id;
	}

	@Column(name = "withholdingamount", precision = 131089, scale = 0)
	public BigDecimal getWithholdingamount() {
		return this.withholdingamount;
	}

	public void setAdClientId(String adClientId) {
		this.adClientId = adClientId;
	}

	public void setAdOrgByAdOrgId(AdOrg adOrgByAdOrgId) {
		this.adOrgByAdOrgId = adOrgByAdOrgId;
	}

	public void setAdOrgByAdOrgtrxId(AdOrg adOrgByAdOrgtrxId) {
		this.adOrgByAdOrgtrxId = adOrgByAdOrgtrxId;
	}

	public void setAdUserId(String adUserId) {
		this.adUserId = adUserId;
	}

	public void setCActivityId(String CActivityId) {
		this.CActivityId = CActivityId;
	}

	public void setCalculatePromotions(String calculatePromotions) {
		this.calculatePromotions = calculatePromotions;
	}

	public void setCBpartner(CBpartner CBpartner) {
		this.CBpartner = CBpartner;
	}

	public void setCBpartnerLocation(CBpartnerLocation CBpartnerLocation) {
		this.CBpartnerLocation = CBpartnerLocation;
	}

	public void setCCampaignId(String CCampaignId) {
		this.CCampaignId = CCampaignId;
	}

	public void setCChargeId(String CChargeId) {
		this.CChargeId = CChargeId;
	}

	public void setCCurrency(CCurrency CCurrency) {
		this.CCurrency = CCurrency;
	}

	public void setCDoctypeByCDoctypeId(CDoctype CDoctypeByCDoctypeId) {
		this.CDoctypeByCDoctypeId = CDoctypeByCDoctypeId;
	}

	public void setCDoctypeByCDoctypetargetId(
			CDoctype CDoctypeByCDoctypetargetId) {
		this.CDoctypeByCDoctypetargetId = CDoctypeByCDoctypetargetId;
	}

	public void setChargeamt(BigDecimal chargeamt) {
		this.chargeamt = chargeamt;
	}

	public void setCInvoiceId(String CInvoiceId) {
		this.CInvoiceId = CInvoiceId;
	}

	public void setCInvoicelines(Set<CInvoiceline> CInvoicelines) {
		this.CInvoicelines = CInvoicelines;
	}

	public void setCInvoicetaxes(Set<CInvoicetax> CInvoicetaxes) {
		this.CInvoicetaxes = CInvoicetaxes;
	}

	public void setCopyfrom(Character copyfrom) {
		this.copyfrom = copyfrom;
	}

	public void setCOrder(COrder COrder) {
		this.COrder = COrder;
	}

	public void setCPaymentterm(CPaymentterm CPaymentterm) {
		this.CPaymentterm = CPaymentterm;
	}

	public void setCProjectId(String CProjectId) {
		this.CProjectId = CProjectId;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public void setCreatefrom(Character createfrom) {
		this.createfrom = createfrom;
	}

	public void setCWithholdingId(String CWithholdingId) {
		this.CWithholdingId = CWithholdingId;
	}

	public void setDateacct(Date dateacct) {
		this.dateacct = dateacct;
	}

	public void setDateinvoiced(Date dateinvoiced) {
		this.dateinvoiced = dateinvoiced;
	}

	public void setDateordered(Date dateordered) {
		this.dateordered = dateordered;
	}

	public void setDateprinted(Date dateprinted) {
		this.dateprinted = dateprinted;
	}

	public void setDaysoutstanding(BigDecimal daysoutstanding) {
		this.daysoutstanding = daysoutstanding;
	}

	public void setDaystilldue(BigDecimal daystilldue) {
		this.daystilldue = daystilldue;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDocaction(String docaction) {
		this.docaction = docaction;
	}

	public void setDocstatus(String docstatus) {
		this.docstatus = docstatus;
	}

	public void setDocumentno(String documentno) {
		this.documentno = documentno;
	}

	public void setDueamt(BigDecimal dueamt) {
		this.dueamt = dueamt;
	}

	public void setEmAprmAddpayment(Character emAprmAddpayment) {
		this.emAprmAddpayment = emAprmAddpayment;
	}

	public void setEmAprmProcessinvoice(String emAprmProcessinvoice) {
		this.emAprmProcessinvoice = emAprmProcessinvoice;
	}

	public void setFinalsettlement(Date finalsettlement) {
		this.finalsettlement = finalsettlement;
	}

	public void setFinPaymentmethod(FinPaymentmethod finPaymentmethod) {
		this.finPaymentmethod = finPaymentmethod;
	}

	public void setFinPaymentPriorityId(String finPaymentPriorityId) {
		this.finPaymentPriorityId = finPaymentPriorityId;
	}

	public void setGenerateto(Character generateto) {
		this.generateto = generateto;
	}

	public void setGrandtotal(BigDecimal grandtotal) {
		this.grandtotal = grandtotal;
	}

	public void setIsactive(char isactive) {
		this.isactive = isactive;
	}

	public void setIsdiscountprinted(char isdiscountprinted) {
		this.isdiscountprinted = isdiscountprinted;
	}

	public void setIspaid(char ispaid) {
		this.ispaid = ispaid;
	}

	public void setIsprinted(char isprinted) {
		this.isprinted = isprinted;
	}

	public void setIsselfservice(char isselfservice) {
		this.isselfservice = isselfservice;
	}

	public void setIssotrx(char issotrx) {
		this.issotrx = issotrx;
	}

	public void setIstaxincluded(Character istaxincluded) {
		this.istaxincluded = istaxincluded;
	}

	public void setLastcalculatedondate(Date lastcalculatedondate) {
		this.lastcalculatedondate = lastcalculatedondate;
	}

	public void setMPricelistId(String MPricelistId) {
		this.MPricelistId = MPricelistId;
	}

	public void setOutstandingamt(BigDecimal outstandingamt) {
		this.outstandingamt = outstandingamt;
	}

	public void setPaymentrule(String paymentrule) {
		this.paymentrule = paymentrule;
	}

	public void setPercentageoverdue(BigDecimal percentageoverdue) {
		this.percentageoverdue = percentageoverdue;
	}

	public void setPoreference(String poreference) {
		this.poreference = poreference;
	}

	public void setPosted(String posted) {
		this.posted = posted;
	}

	public void setProcessed(char processed) {
		this.processed = processed;
	}

	public void setProcessing(Character processing) {
		this.processing = processing;
	}

	public void setSalesrepId(String salesrepId) {
		this.salesrepId = salesrepId;
	}

	public void setTaxdate(Date taxdate) {
		this.taxdate = taxdate;
	}

	public void setTotallines(BigDecimal totallines) {
		this.totallines = totallines;
	}

	public void setTotalpaid(BigDecimal totalpaid) {
		this.totalpaid = totalpaid;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public void setUpdatepaymentmonitor(char updatepaymentmonitor) {
		this.updatepaymentmonitor = updatepaymentmonitor;
	}

	public void setUser1Id(String user1Id) {
		this.user1Id = user1Id;
	}

	public void setUser2Id(String user2Id) {
		this.user2Id = user2Id;
	}

	public void setWithholdingamount(BigDecimal withholdingamount) {
		this.withholdingamount = withholdingamount;
	}

}
