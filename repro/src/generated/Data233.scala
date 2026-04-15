package generated

final case class Data233(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data233 = copy(name = name.toUpperCase)
  def scale(k: Double): Data233 = copy(value = value * k)
  def addTag(t: String): Data233 = copy(tags = t :: tags)
  def put(k: String, v: String): Data233 = copy(meta = meta.updated(k, v))
  def merge(other: Data233): Data233 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data233 {
  given Ordering[Data233] = Ordering.by(_.id)
  def empty: Data233 = Data233(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data233 =
    Data233(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data233] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
