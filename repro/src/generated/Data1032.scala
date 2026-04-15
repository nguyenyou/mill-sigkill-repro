package generated

final case class Data1032(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1032 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1032 = copy(value = value * k)
  def addTag(t: String): Data1032 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1032 = copy(meta = meta.updated(k, v))
  def merge(other: Data1032): Data1032 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1032 {
  given Ordering[Data1032] = Ordering.by(_.id)
  def empty: Data1032 = Data1032(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1032 =
    Data1032(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1032] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
