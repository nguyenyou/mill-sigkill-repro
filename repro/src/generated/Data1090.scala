package generated

final case class Data1090(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1090 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1090 = copy(value = value * k)
  def addTag(t: String): Data1090 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1090 = copy(meta = meta.updated(k, v))
  def merge(other: Data1090): Data1090 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1090 {
  given Ordering[Data1090] = Ordering.by(_.id)
  def empty: Data1090 = Data1090(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1090 =
    Data1090(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1090] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
