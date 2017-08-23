# [Practice]
Uploading private project.

[Codecov][0] Java Maven Example
===============================

1. Add `cobertura-maven-plugin` plugin to your pom.xml file, [see here](https://github.com/malaypatel/Practice/blob/master/pom.xml#L32-L43)
1. Call `mvn cobertura:cobertura` during your CI tests
1. Call `bash <(curl -s https://codecov.io/bash)` at the end of your CI build
  - Using Travis CI, CircleCI or AppVeyor **AND** the repository is public? **You're done!** No token needed.
  - Otherwise, please add your [repository token token][2].
  
  
  
[0]: https://codecov.io/
[1]: http://docs.codecov.io/docs/about-the-codecov-bash-uploader#section-upload-token
