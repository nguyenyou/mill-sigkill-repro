package generated

final case class Data855(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data855 = copy(name = name.toUpperCase)
  def scale(k: Double): Data855 = copy(value = value * k)
  def addTag(t: String): Data855 = copy(tags = t :: tags)
  def put(k: String, v: String): Data855 = copy(meta = meta.updated(k, v))
  def merge(other: Data855): Data855 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data855 {
  given Ordering[Data855] = Ordering.by(_.id)
  def empty: Data855 = Data855(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data855 =
    Data855(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data855] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
