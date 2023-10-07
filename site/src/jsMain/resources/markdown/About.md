---
root: .components.layouts.MarkdownLayout("About")
---

This template is intended to serve as both a way to see some fundamentals of the Kobweb framework in action as well as
be a starting point you can build your own app from.

## LEARN

### FILES

If this is your first time using Kobweb, please open your project in an IDE and take a few minutes to look around the
code.

* `AppEntry.kt` - This file declares a method that is an entry point for all pages on your site. You can rename the file
  and the method if you like. Kobweb searches for a single method at compile time annotated with `@App`.
* `AppStyles.kt` - An example of declaring generally useful styles that can potentially be used across the whole site.
* `SiteTheme.kt` - An example of how to define some site-specific colors, effectively extending the palette provided by
  Silk.
* `components/` - By convention, Kobweb codebases organize reusable site components under this folder. Within it, you
  have:
    * `layout/` - represents top-level organization for pages (this template only has a single layout, and that's
      normal)
    * `sections/` - represents areas of content that appear across multiple pages (such as header bars and footers)
    * `widgets/` - home for low-level UI pieces that you can use around your site
* `pages/` - Any @Composable under this folder additionally tagged with @Page will have a route generated for it
  automatically. Defining a page outside of this folder will be flagged as an error by the Kobweb Gradle plugin at
  compile time.
* `resources/`
  * `public` - If you want to host any media (such as an icon, an image, text configuration files, movies,
  fonts, etc.), you should put it under this folder.
  * `markdown` - Any markdown discovered in here by Kobweb at compile time will be converted into pages on your
  site.

### CLASSES

The Kobweb and Silk APIs introduce a lot of powerful concepts. Here are some of the most important ones to know about
which you can find used throughout this template:

* `Modifier` - Kobweb introduces the modifier keyword that Android developers may recognize from the Jetpack Compose API.
In a webdev context, this is used for setting CSS styles and html attributes on elements in the page. With Kobweb,
you'll eventually need to learn about the various CSS APIs, but it is hoped
* `ComponentStyle` - Traditional HTML pages use CSS to style their UI. In Kobweb, this is accomplished using the
ComponentStyle class, which is a Kotlin-idiomatic way to declare such CSS styling information inside your code. You can
find examples of component styles used throughout the template. You can click here to read more about ComponentStyles.
* `ComponentVariant` - You can generate variants from component styles, which are ways to take base component styles and
tweak them further.
* `Keyframes` - You can create animations by declaring keyframes for them.

## STARTING POINT

This template aims to create some generally useful pieces that most sites will want to use, either as is or with a few
tweaks. Making your own site could be as easy as deleting this About page and working from there. However, you are
welcome to modify or delete anything you find in the template that you don't plan to use in your final site.

If instead you'd like to start from scratch, you can run `$ kobweb create app/empty` which will create a new project
with nothing inside of it except for a minimal, skeletal structure.

## EXPORT AND UPLOAD

When you are ready to share your site with the world, you'll want to export it first. This will create a production
snapshot of your site.

There are two flavors of Kobweb sites: *static layout* and *full stack*. You
can [read more about these choices here](https://github.com/varabyte/kobweb#static-layout-vs-full-stack-sites).

For most sites, a static layout site is what you want, so to do that, return to the command line and run:

```
$ kobweb export --layout static
```

After that runs for a little while, your production site should be generated! You can find the files under the
`.kobweb/site` folder.

Test it locally by running:

```
$ kobweb run --layout static --env prod
```

If you're satisfied, you can upload your site files to the static website host provider of your choice. Each provider
has its own instructions for how it discovers your files, so please refer to their documentation.

You can [read this blog post](https://bitspittle.dev/blog/2022/staticdeploy) for some concrete examples of exporting a
Kobweb site to two popular static website hosting providers.
