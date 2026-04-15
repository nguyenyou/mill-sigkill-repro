package generated

final case class Data54(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data54 = copy(name = name.toUpperCase)
  def scale(k: Double): Data54 = copy(value = value * k)
  def addTag(t: String): Data54 = copy(tags = t :: tags)
  def put(k: String, v: String): Data54 = copy(meta = meta.updated(k, v))
  def merge(other: Data54): Data54 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data54 {
  given Ordering[Data54] = Ordering.by(_.id)
  def empty: Data54 = Data54(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data54 =
    Data54(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data54] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
