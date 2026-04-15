package generated

final case class Data708(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data708 = copy(name = name.toUpperCase)
  def scale(k: Double): Data708 = copy(value = value * k)
  def addTag(t: String): Data708 = copy(tags = t :: tags)
  def put(k: String, v: String): Data708 = copy(meta = meta.updated(k, v))
  def merge(other: Data708): Data708 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data708 {
  given Ordering[Data708] = Ordering.by(_.id)
  def empty: Data708 = Data708(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data708 =
    Data708(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data708] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
