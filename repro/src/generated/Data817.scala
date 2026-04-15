package generated

final case class Data817(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data817 = copy(name = name.toUpperCase)
  def scale(k: Double): Data817 = copy(value = value * k)
  def addTag(t: String): Data817 = copy(tags = t :: tags)
  def put(k: String, v: String): Data817 = copy(meta = meta.updated(k, v))
  def merge(other: Data817): Data817 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data817 {
  given Ordering[Data817] = Ordering.by(_.id)
  def empty: Data817 = Data817(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data817 =
    Data817(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data817] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
