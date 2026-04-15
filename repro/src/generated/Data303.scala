package generated

final case class Data303(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data303 = copy(name = name.toUpperCase)
  def scale(k: Double): Data303 = copy(value = value * k)
  def addTag(t: String): Data303 = copy(tags = t :: tags)
  def put(k: String, v: String): Data303 = copy(meta = meta.updated(k, v))
  def merge(other: Data303): Data303 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data303 {
  given Ordering[Data303] = Ordering.by(_.id)
  def empty: Data303 = Data303(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data303 =
    Data303(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data303] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
