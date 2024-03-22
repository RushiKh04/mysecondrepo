package com.scripts.AdaniPESC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.views.AdaniPESC.ATRSScanView;
import com.views.AdaniPESC.AllIncidentsView;
import com.views.AdaniPESC.BoardingPassDetailsView;
import com.views.AdaniPESC.BoardingPassView;
import com.views.AdaniPESC.DashboardView;
import com.views.AdaniPESC.FoundItemsDetailsView;
import com.views.AdaniPESC.IncidentDetailsView;
import com.views.AdaniPESC.ItemSelectionView;
import com.views.AdaniPESC.LoginLogoutView;
import com.views.AdaniPESC.OTPVerificationView;
import com.views.AdaniPESC.SelectBagPaxView;

import aQute.lib.getopt.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class AdaniPESC_TestCase extends BaseTest {

	private ATRSScanView objAtrsScanView;
	private BoardingPassView objBoardingPassView;
	private BoardingPassDetailsView objBoardingPassDetailsView;
	private SelectBagPaxView objSelectBagPaxView;
	private FoundItemsDetailsView objFoundItemsDetailsView;
	private LoginLogoutView objLoginLogoutView;
	private OTPVerificationView objOtpVerificationView;
	private ItemSelectionView objItemSelectionView;
	private DashboardView objDashboardView;
	private AllIncidentsView objAllIncidentsView;
	private IncidentDetailsView objIncidentDetailsView;

	// Initialize View and Pages
	public void initializeViewsAndPages() {
		objAtrsScanView = new ATRSScanView(this);
		objBoardingPassView = new BoardingPassView(this);
		objBoardingPassDetailsView = new BoardingPassDetailsView(this);
		objSelectBagPaxView = new SelectBagPaxView(this);
		objFoundItemsDetailsView = new FoundItemsDetailsView(this);
		objLoginLogoutView = new LoginLogoutView(this);
		objOtpVerificationView = new OTPVerificationView(this);
		objItemSelectionView = new ItemSelectionView(this);
		objDashboardView = new DashboardView(this);
		objAllIncidentsView = new AllIncidentsView(this);
		objIncidentDetailsView = new IncidentDetailsView(this);
	}

	@BeforeClass(groups = { "P1", "P2", "P3" })
	public void initializeEnvironment() {
		initializeWebEnvironment("excel/TestDataAdaniPESC");
		this.initializeViewsAndPages();
	}

	@Title("TCID_01_CreateIncident")
	@Description("Create incident")
	@Test(priority = 1, groups = { "P1" })
	public void TCID_01_CreateIncident() {
		loadTestData("TCID_01_CreateIncident");
//		objLoginLogoutView.verifyLogo();
//        objLoginLogoutView.verifyLoginHeader();
//        objLoginLogoutView.doLogin();
//        objOtpVerificationView.verifyHeaderOnOtpVerificationPage();
//        objOtpVerificationView.setOTP();

		objAtrsScanView.verifyATRSScanHeaders();
		objAtrsScanView.findATRSMachine();
		objAtrsScanView.getATRSDetails();
		objAtrsScanView.clickOnNextBtn();

		objBoardingPassView.verifyBoardingPassPageHeaders();
		objBoardingPassView.clickOnFillDetailsManuallyBtn();

		objBoardingPassDetailsView.verifyBoardingPassDetailsHeaders();
		objBoardingPassDetailsView.fillDetailsForBoardingPass();
		objBoardingPassDetailsView.clickOnSaveBtn();
		objBoardingPassView.getBoardingPassDetails();
		objBoardingPassDetailsView.clickOnNextBtn();

		objSelectBagPaxView.verifySelectBagPaxPageHeader();
		objSelectBagPaxView.selectBag();
		objSelectBagPaxView.selectTestTypeForETD();
		objSelectBagPaxView.clickOnYesBtnForFoundItems();
		objSelectBagPaxView.clickOnContinueBtn();

		objItemSelectionView.verifyBreadcrumb();
		objItemSelectionView.selectItemFromList();

		objFoundItemsDetailsView.verifyBreadcrumb();
		objFoundItemsDetailsView.selectCheckedAndAllowedRadioBtn();
		objFoundItemsDetailsView.setTextToCommentsBox();
		objFoundItemsDetailsView.captureImage();
		objFoundItemsDetailsView.captureImage();
		objFoundItemsDetailsView.clickOnSaveAndCreateIncident();
		objFoundItemsDetailsView.getDetailsOfIncidentPopUp();
		objFoundItemsDetailsView.clickOnAddMoreBtnOnIncidentDetailsPopup();

		objSelectBagPaxView.verifySelectBagPaxPageHeader();
		objSelectBagPaxView.selectPax();
		objSelectBagPaxView.SelectTestTypeForPatDown();
		objSelectBagPaxView.clickOnYesBtnForFoundItems();
		objSelectBagPaxView.clickOnContinueBtn();

		objItemSelectionView.verifyBreadcrumb();
		objItemSelectionView.selectItemFromList();

		objFoundItemsDetailsView.verifyBreadcrumb();
		objFoundItemsDetailsView.selectDisposedRadioBtn();
		objFoundItemsDetailsView.verifyFoundRemovedAllowedFunctionality();
		objFoundItemsDetailsView.setTextToCommentsBox();
		objFoundItemsDetailsView.captureImage();
		objFoundItemsDetailsView.captureImage();
		objFoundItemsDetailsView.clickOnSaveAndCreateIncident();
		objFoundItemsDetailsView.getDetailsOfIncidentPopUp();
		objFoundItemsDetailsView.clickOnAddMoreBtnOnIncidentDetailsPopup();

		objSelectBagPaxView.selectBag();
		objSelectBagPaxView.selectTestTypeForETD();
		objSelectBagPaxView.clickOnNoBtnForFoundItems();
		objFoundItemsDetailsView.setTextToCommentsBox();
		objFoundItemsDetailsView.clickOnSaveAndCreateIncident();
		objFoundItemsDetailsView.getDetailsOfIncidentPopUp();
		objFoundItemsDetailsView.clickOnFinishBtn();

		objDashboardView.openDashboardPage();
		objDashboardView.verifyDashboardPageHeader();
		objDashboardView.verifyIncidentLabel();
	}

	@Title("TCID_02_VerifyDashboard")
	@Description("Verify  Dashboard")
	@Test(priority = 2, groups = { "P1" })
	public void TCID_02_VerifyDashboard() {
		loadTestData("TCID_02_VerifyDashboard");
		objDashboardView.openDashboardPage();
		objDashboardView.verifyDashboardPageHeader();
		objDashboardView.applyMoreFilters();
		objDashboardView.setDatesAndTime();
		objDashboardView.validateCards();
		objDashboardView.verifyIncidentLabel();
		objDashboardView.clickOnIncidentLabel();
		
		objIncidentDetailsView.verifyIncidentDetailsPageHeader();
		objIncidentDetailsView.verifyIncidentDetails();
		objIncidentDetailsView.clickOnBoardingPassDetails();
		objIncidentDetailsView.navigateBack();
		objIncidentDetailsView.clickOnIncidentStatus();
		
		objItemSelectionView.verifyBreadcrumb();
		
		objIncidentDetailsView.navigateBack();
		objIncidentDetailsView.navigateBack();
	}

	@Title("TCID_03_EditIncident")
	@Description("Edit incident on Dashboard Page")
	@Test(priority = 2, groups = { "P1" })
	public void TCID_03_EditIncident() {
		 loadTestData("TCID_03_EditIncident");
		 objDashboardView.openDashboardPage();
		 objDashboardView.verifyDashboardPageHeader();
		 objDashboardView.setDatesAndTime();
		 objDashboardView.verifyIncidentLabel();		
		 objDashboardView.clickOnIncidentLabel();
		 
		 objIncidentDetailsView.verifyIncidentDetailsPageHeader();
		 objIncidentDetailsView.verifyIncidentDetails();
		 objIncidentDetailsView.clickOnBoardingPassDetails();
		 objIncidentDetailsView.navigateBack();
		 objIncidentDetailsView.clickOnIncidentStatus();
		 objIncidentDetailsView.navigateBack(); 
		 objIncidentDetailsView.navigateBack();
		 
		 objDashboardView.editFirstIncident(); 
		 
		 objSelectBagPaxView.selectBag();
		 objSelectBagPaxView.SelectTestTypeForPhysicalCheck();
		 objSelectBagPaxView.clickOnYesBtnForFoundItems();
		 objSelectBagPaxView.clickOnContinueBtn();
		 
		 objItemSelectionView.verifyBreadcrumb();
		 objItemSelectionView.selectItemFromList();
		 
		 objFoundItemsDetailsView.verifyBreadcrumb();
		 objFoundItemsDetailsView.selectCheckedAndAllowedRadioBtn();
		 objFoundItemsDetailsView.captureImage();
		 objFoundItemsDetailsView.clickOnSaveAndCreateIncident();
		 objFoundItemsDetailsView.getDetailsOfIncidentPopUp();
		 objFoundItemsDetailsView.clickOnFinishBtn(); 
		}

	@Title("TCID_04_DeleteCreatedIncident")
	@Description("Delete created incident")
	@Test(priority = 2, groups = { "P1" })
	public void TCID_04_DeleteCreatedIncident() {
		loadTestData("TCID_04_DeleteCreatedIncident");
		objDashboardView.openDashboardPage();
		objDashboardView.verifyDashboardPageHeader();
		objDashboardView.verifyIncidentLabel();
		objDashboardView.clickOnIncidentLabel();
		
		objIncidentDetailsView.verifyIncidentDetailsPageHeader();
		objIncidentDetailsView.verifyIncidentDetails();
		objIncidentDetailsView.clickOnBoardingPassDetails();
		objIncidentDetailsView.navigateBack();
		objIncidentDetailsView.clickOnIncidentStatus();
		objIncidentDetailsView.navigateBack();
		objIncidentDetailsView.navigateBack();
		
		objDashboardView.deleteFirstIncident();
	}

	@Title("TCID_05_VerifyViewAllIncident")
	@Description("Verify view all incident")
	@Test(priority = 2, groups = { "P1" })
	public void TCID_05_VerifyViewAllIncident() {
		loadTestData("TCID_05_VerifyViewAllIncident");
		objDashboardView.openDashboardPage();
		objDashboardView.verifyDashboardPageHeader();
		objDashboardView.clickViewAllIncidents();
		
		objAllIncidentsView.applyMoreFilters();
		objAllIncidentsView.setDatesAndTime();
		objAllIncidentsView.searchIncident();
		objAllIncidentsView.verifyIncidentLabel();
		objAllIncidentsView.clickIncidentLabel();
		
		objIncidentDetailsView.verifyIncidentDetailsPageHeader();
		objIncidentDetailsView.verifyIncidentDetails();
		objIncidentDetailsView.clickOnBoardingPassDetails();
		objIncidentDetailsView.navigateBack();
		objIncidentDetailsView.clickOnIncidentStatus();
		objIncidentDetailsView.navigateBack();
		objIncidentDetailsView.navigateBack();
	}

	@AfterClass(groups = { "P1", "P2", "P3" })
	public void tearDownEnvironment() {
		// tearDownWebEnvironment();
		objAtrsScanView = null;
		objBoardingPassView = null;
		objBoardingPassDetailsView = null;
		objSelectBagPaxView = null;
		objFoundItemsDetailsView = null;
		objLoginLogoutView = null;
		objOtpVerificationView = null;
	}
}
