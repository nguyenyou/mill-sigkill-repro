package generated

final case class Data864(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data864 = copy(name = name.toUpperCase)
  def scale(k: Double): Data864 = copy(value = value * k)
  def addTag(t: String): Data864 = copy(tags = t :: tags)
  def put(k: String, v: String): Data864 = copy(meta = meta.updated(k, v))
  def merge(other: Data864): Data864 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data864 {
  given Ordering[Data864] = Ordering.by(_.id)
  def empty: Data864 = Data864(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data864 =
    Data864(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data864] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
