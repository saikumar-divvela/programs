import shlex
import re
import os

test ="chmod +x -R /var/lib/jenkins/jobs/notify-build-result/workspace/"
cmd = shlex.split(test)[0]
#print (cmd)
#print('osc results %s -l --xml | grep %s |sort -u | awk -F \'\"\' \'{print$2}\'')

info='{"target": [{"repo": "target", "name": "mobile_boot", "buildid": "tizen-2.4-mobile_20150204.6", "project": "Tizen:2.4:Mobile", "images_path": "images/mobile_boot", "url_pub_base": "http://168.219.209.55", "repo_path": "snapshots/2.4-mobile/common/tizen-2.4-mobile_20150204.6"}, {"repo": "target", "name": "mobile_bootdebug", "buildid": "tizen-2.4-mobile_20150204.6", "project": "Tizen:2.4:Mobile", "images_path": "images/mobile_bootdebug", "url_pub_base": "http://168.219.209.55", "repo_path": "snapshots/2.4-mobile/common/tizen-2.4-mobile_20150204.6"}, {"repo": "target", "name": "mobile_target", "buildid": "tizen-2.4-mobile_20150204.6", "project": "Tizen:2.4:Mobile", "images_path": "images/mobile_target", "url_pub_base": "http://168.219.209.55", "repo_path": "snapshots/2.4-mobile/common/tizen-2.4-mobile_20150204.6"}]}'

repo_name="target"
url_pub_base="http://168.219.209.55/download"
repo_path="snapshots/2.4-mobile/common/tizen-2.4-mobile_20150204.6"
current_repo_url ="http://168.219.209.55/download/snapshots/2.4-mobile/common/tizen-2.4-mobile_20150204.6/repos/target/packages"
buildid="tizen-2.4-mobile_20150204.6"
lastest_build = repo_path.split('/')[-1]
last_build_url = os.path.join(url_pub_base, repo_path[:repo_path.rfind('/')])
prefix_pattern = 'tizen-' + last_build_url.split('/')[-2]
last_repo_base=" http://168.219.209.55/download/snapshots/2.4-mobile/common/tizen-2.4-mobile_20150204.5"
last_repo_url = os.path.join(last_repo_base, 'repos', repo_name, 'packages')

print("\nURL_PUB_BASE :",url_pub_base)
print("\nREPO_PATH :",repo_path)
print("\nBUILD_ID :",buildid)
print("\nLASTEST_BUILD :",lastest_build)
print("\nLAST_BUILD_URL :",last_build_url)
print("\nPREFIX_PATTERN :",prefix_pattern)
print("\nCURRENT_REPO_URL :",current_repo_url)
print("\nLAST_REPO_URL :",last_repo_url)
print("\nLAST_BUILD_ID :",re.search(r'\w*_\d{8}\.\d*', last_repo_url).group(0))
print("\n",('/'.join(repo_path.split('/')[1:-1])))
