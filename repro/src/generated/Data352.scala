package generated

final case class Data352(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data352 = copy(name = name.toUpperCase)
  def scale(k: Double): Data352 = copy(value = value * k)
  def addTag(t: String): Data352 = copy(tags = t :: tags)
  def put(k: String, v: String): Data352 = copy(meta = meta.updated(k, v))
  def merge(other: Data352): Data352 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data352 {
  given Ordering[Data352] = Ordering.by(_.id)
  def empty: Data352 = Data352(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data352 =
    Data352(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data352] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
