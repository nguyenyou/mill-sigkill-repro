package generated

final case class Data389(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data389 = copy(name = name.toUpperCase)
  def scale(k: Double): Data389 = copy(value = value * k)
  def addTag(t: String): Data389 = copy(tags = t :: tags)
  def put(k: String, v: String): Data389 = copy(meta = meta.updated(k, v))
  def merge(other: Data389): Data389 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data389 {
  given Ordering[Data389] = Ordering.by(_.id)
  def empty: Data389 = Data389(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data389 =
    Data389(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data389] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
