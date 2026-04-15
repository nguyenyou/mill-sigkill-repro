package generated

final case class Data446(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data446 = copy(name = name.toUpperCase)
  def scale(k: Double): Data446 = copy(value = value * k)
  def addTag(t: String): Data446 = copy(tags = t :: tags)
  def put(k: String, v: String): Data446 = copy(meta = meta.updated(k, v))
  def merge(other: Data446): Data446 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data446 {
  given Ordering[Data446] = Ordering.by(_.id)
  def empty: Data446 = Data446(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data446 =
    Data446(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data446] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
