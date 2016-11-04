prerelease_project = "Tizen:2.3:Mobile:submit:"
for tag in (':submit:', ':accepted:', ':submitgroup:'):
    splitted = prerelease_project.split(tag)
    if len(splitted) > 1:
        print (':'.join(splitted[0].split(':')[2:]), splitted[-1].split(':')[-1])

print("done")
