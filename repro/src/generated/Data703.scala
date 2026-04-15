package generated

final case class Data703(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data703 = copy(name = name.toUpperCase)
  def scale(k: Double): Data703 = copy(value = value * k)
  def addTag(t: String): Data703 = copy(tags = t :: tags)
  def put(k: String, v: String): Data703 = copy(meta = meta.updated(k, v))
  def merge(other: Data703): Data703 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data703 {
  given Ordering[Data703] = Ordering.by(_.id)
  def empty: Data703 = Data703(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data703 =
    Data703(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data703] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
