package generated

final case class Data412(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data412 = copy(name = name.toUpperCase)
  def scale(k: Double): Data412 = copy(value = value * k)
  def addTag(t: String): Data412 = copy(tags = t :: tags)
  def put(k: String, v: String): Data412 = copy(meta = meta.updated(k, v))
  def merge(other: Data412): Data412 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data412 {
  given Ordering[Data412] = Ordering.by(_.id)
  def empty: Data412 = Data412(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data412 =
    Data412(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data412] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
