package com.insurance.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entity.Insurance;
import com.insurance.entity.Policy;
import com.insurance.entity.User;
import com.insurance.exception.ResourceNotFoundException;
import com.insurance.repo.InsuranceRepo;
import com.insurance.repo.PolicyRepo;
import com.insurance.repo.UserRepo;
import com.insurance.service.InsuranceService;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	private static final Logger log = LoggerFactory.getLogger(InsuranceServiceImpl.class);

	@Autowired
	private InsuranceRepo insuranceRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PolicyRepo policyRepo;

	@Override
	public List<Insurance> getInsuranceList() {
		List<Insurance> allInsurances = insuranceRepo.findAll();
		return allInsurances;
	}

	@Override
	public String saveUsers(List<User> userList, int insuranceId) {
		log.info("Saving policy details in database");
		Policy policy = new Policy();
		policy.setToDate(LocalDateTime.now());
		System.out.println(userList);
		policy.setUserList(userList);
		Policy savedPolicy = policyRepo.save(policy);
		log.info("Saved policy for {}", savedPolicy.getPolicyId());

		List<User> finalList = new ArrayList<>();
		for (User user : userList) {
			user.setPolicy(savedPolicy);
			finalList.add(user);
		}
		userRepo.saveAll(finalList);
		return "Details Saved";
	}

	@Override
	public List<Object> createReport(int policyId) {
		Policy policyDetails = null;

		policyDetails = policyRepo.getPolicyDetails(policyId);
		if (policyDetails == null) {
			throw new ResourceNotFoundException("Policy", "policyId", policyId);
		}

		int insuranceId = policyDetails.getInsuranceId();
		LocalDateTime fromDate = policyDetails.getFromDate();
		LocalDateTime toDate = policyDetails.getToDate();
		// System.out.println(policyDetails);

		Insurance insurance = insuranceRepo.findById(insuranceId)
				.orElseThrow(() -> new ResourceNotFoundException("Insurance", "Insurance Id", insuranceId));
		String companyName = insurance.getCompanyName();
		String insuranceType = insurance.getInsuranceType();
		String planName = insurance.getPlanName();

		System.out.println(insurance);
		String userName = userRepo.fetchUserName(policyId);
		System.out.println(userName);

		List<Object> list = new ArrayList<Object>();
		list.add(policyId);
		list.add(fromDate);
		list.add(toDate);
		list.add(companyName);
		list.add(insuranceType);
		list.add(planName);
		list.add(userName);

		return list;
	}

	private void addTableHeader(PdfPTable table) {
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10f, BaseColor.BLACK);
		Stream.of("Sr.No", "Policy Id", "Policy Name", "Policy Type", "Insurance Name", "Proposer Name", "Valid From",
				"Valid Upto").forEach(columnTitle -> {
					PdfPCell header = new PdfPCell();
					header.setBackgroundColor(BaseColor.CYAN);
					header.setBorderWidth(2);
					header.setPhrase(new Phrase(3, columnTitle, font));

					table.addCell(header);
				});
	}

	private void addRows(PdfPTable table, List<Object> reportDetails) throws DocumentException, URISyntaxException, IOException {

		//List<Object> reportDetails = createReport(policyId);

		int policyNo = (Integer) reportDetails.get(0);
		LocalDateTime fromDate = (LocalDateTime) reportDetails.get(1);
		LocalDateTime toDate = (LocalDateTime) reportDetails.get(2);
		String companyName = (String) reportDetails.get(3);
		String insuranceType = (String) reportDetails.get(4);
		String policyName = (String) reportDetails.get(5);
		String userName = (String) reportDetails.get(6);

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10f, BaseColor.BLACK);

		table.addCell("1");
		table.addCell(String.valueOf(policyNo));
		table.addCell(policyName);
		table.addCell(insuranceType);
		table.addCell(companyName);
		table.addCell(userName);

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fromDateString = fromDate.format(dateTimeFormatter);
		table.addCell(fromDateString);

		String toDateString = toDate.format(dateTimeFormatter);
		table.addCell(toDateString);

//		table.addCell("");
//		table.addCell("row 1, col 3");
//		table.addCell(companyName);
//		table.addCell("row 1, col 3");
//		table.addCell("row 1, col 3");
//		table.addCell("row 1, col 3");
//		table.addCell("row 1, col 3");
	}

	private void addCustomRows(PdfPTable table) throws URISyntaxException, BadElementException, IOException {
//		Path path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
//		Image img = Image.getInstance(path.toAbsolutePath().toString());
//		img.scalePercent(10);
//
//		PdfPCell imageCell = new PdfPCell(img);
//		table.addCell(imageCell);

		PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("STAR HEALTH INSURANCE"));
		horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(horizontalAlignCell);

		PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
		verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		table.addCell(verticalAlignCell);
	}

	public void generatePdf(List<Object> reportDetails) throws DocumentException, URISyntaxException, IOException {

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Hp\\Desktop\\Report\\Report1.pdf"));

		document.open();

		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.0f, 1.5f, 2.5f, 2.5f, 2.5f, 3.5f, 1.5f, 1.5f });
		table.setSpacingBefore(10);
		addTableHeader(table);

		// addCustomRows(table);
		addRows(table, reportDetails);
		document.add(table);
		System.out.println("Table created successfully");
		document.close();

	}

}
