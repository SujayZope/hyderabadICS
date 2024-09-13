package lk.restaurant.Reports;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ReportManager {

    JRViewer jrv = null;
    JasperReport jasperReport;
    JasperPrint jasperPrint = null;


    public void invoice()throws Exception{
        JasperDesign load = JRXmlLoader.load("C:\\Users\\Hash\\Desktop\\ites_project\\Hotel-POS\\src\\main\\java\\lk\\ites\\HotelPOS\\Reports\\Invoice\\Invoice.jrxml");
        String sql="";
        JRDesignQuery jrDesignQuery = new JRDesignQuery();
        jrDesignQuery.setText(sql);

        load.setQuery(jrDesignQuery);

        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("like","");


        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, objectObjectHashMap);
        JasperViewer.viewReport(jasperPrint);



    }




    public void generateReport(String reportSource, Map<String, Object> params, String title, Connection con, int printer, int restId) throws JRException {
        try {
            System.out.println("Printer : " + printer);
            System.out.println("Restu : " + restId);
            System.out.println("Report Source :" + reportSource);
            jasperReport = JasperCompileManager.compileReport(reportSource);
            System.out.println("Connection" + con);
            System.out.println("Jasper :" + jasperReport.getCompilerClass());
            System.out.println("Jasper :" + jasperReport.getCompileNameSuffix());
            System.out.println("Jasper :" + jasperReport.getCompileData());
            jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
            if (printer == 1) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, "C://my/abc1.pdf");
                JRSaver.saveObject(jasperPrint, "C://my/posReport1.jrprint");
            }
//            Print(printerName(printer, restId), printer);
        }catch (JRException ex) {
                params = null;
                reportSource = null;
                title = null;
            }

        params = null;
        reportSource = null;
        title = null;

    }
    public void Print(String name, int printerId) {
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
//        attributeSet.add(MediaSizeName.ISO_A7);

        PrintServiceAttributeSet set = new HashPrintServiceAttributeSet();

        set.add(new PrinterName(name, null));
        JRPrintServiceExporter exporter = new JRPrintServiceExporter();

        if (printerId == 1) {
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport1.jrprint");
        } else if(printerId == 2) {
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport2.jrprint");
        } else if (printerId == 3) {
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport3.jrprint");
        } else if (printerId == 4){
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport4.jrprint");
        }else if(printerId == 5) {
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport5.jrprint");
        } else if (printerId == 6) {
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport6.jrprint");
        } else if (printerId == 7){
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport7.jrprint");
        }else if(printerId == 8) {
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport8.jrprint");
        } else if (printerId == 9) {
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport9.jrprint");
        } else if (printerId == 10){
            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport10.jrprint");
        }
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, attributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, set);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
        try {
            exporter.exportReport();
        } catch (JRException ex) {
//            message = new JDialogMessage(null, true, "Printer is not found", "Message", icon);
//            message.setVisible(true);
        }

    }

    public String document_parth() {
        //String a="M:/";
        //  String a="C:/payroll_report/";
        String a = System.getProperty("user.dir") + File.separatorChar + "src\\main\\java\\lk\\ites\\HotelPOS\\Reports\\";
        System.out.println("Document Path+"+a);
        // String a="C:/payroll/";
        return a;
    }

    public void printReport(JasperPrint jasperPrint, String title) {
        jrv = new JRViewer(jasperPrint);
        jrv.setPreferredSize(new Dimension(850, 700));
        JScrollPane reportScroll = new JScrollPane(jrv);
        JInternalFrame viewer = new JInternalFrame();
        viewer.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {

            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                jrv.clear();
                jrv = null;
            }

            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }

            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        viewer.setClosable(true);
        viewer.add(reportScroll);
        int y = 1;
        int x = 1;
        viewer.setLocation(x, y);
        viewer.setTitle(title);
        viewer.pack();
//        POS_Main.desktopPane.add(viewer);
        viewer.setVisible(true);
        Toolkit theKit = viewer.getToolkit(); // Get the window toolkit
        Dimension wndSize = theKit.getScreenSize(); // Get screen size
        viewer.setBounds(0, 0, (wndSize.width - 9), (wndSize.height - 33));
    }

    public void generateReport(InputStream reportSource, Map<String, Object> params, String title, Connection con) {

        JasperReport jasperReport;
        try {

            //jasperReport = JasperCompileManager.compileReport(reportSource);
            jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);

            //JasperPrint jasperPrint = (JasperPrint)JRLoader.loadObject(sourceFile);
            //JasperExportManager.exportReportToHtmlFile(jasperPrint, reportDest);

            printReport(jasperPrint, title);

            // JasperViewer.viewReport(jasperPrint);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }

    }

    public URL document_parth(String path) {
        URL uri = null;
        uri = getClass().getResource("src/main/java/lk/ites/HotelPOS/Reports/" + path);
        return uri;
    }
}
