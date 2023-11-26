import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { registerLicense } from '@syncfusion/ej2-base';


registerLicense('@32332e302e30Ch+WG/v5zP9igTAj5jwcyW7F4pUcdNJZzY8G1lZoPIQ=');
platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
