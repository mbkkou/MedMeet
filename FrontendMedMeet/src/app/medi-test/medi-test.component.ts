import { Component } from '@angular/core';

@Component({
  selector: 'app-medi-test',
  templateUrl: './medi-test.component.html',
  styleUrls: ['./medi-test.component.css']
})
export class MediTestComponent {
  uploadedFiles: File[] = [];

  onFileSelected(event: any) {
    const files: File[] = event.target.files;
    for (const file of files) {
      this.uploadedFiles.push(file);
    }
  }

  uploadFiles() {
    // Implement your logic to save/upload the files to your desired location
    // You can use services or APIs to handle the upload process
  }

  removeFile(file: File) {
    const index = this.uploadedFiles.indexOf(file);
    if (index !== -1) {
      this.uploadedFiles.splice(index, 1);
    }
  } 
}



