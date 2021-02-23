# クエリパラメータの取得

```
import { Router, ActivatedRoute } from '@angular/router';

...

constructor(
  private route ActivatedRoute,
) {}

...

ngOnInit(): void {
  this.route.queryParams.subscribe(param => {
    console.log(param);
    // '?firstname=sora&lastname=tokui'
    // ↓
    // {
    //   firstname: sora,
    //   lastname: tokui
    // }
  });
```
