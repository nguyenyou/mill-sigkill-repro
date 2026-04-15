package generated

final case class Data978(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data978 = copy(name = name.toUpperCase)
  def scale(k: Double): Data978 = copy(value = value * k)
  def addTag(t: String): Data978 = copy(tags = t :: tags)
  def put(k: String, v: String): Data978 = copy(meta = meta.updated(k, v))
  def merge(other: Data978): Data978 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data978 {
  given Ordering[Data978] = Ordering.by(_.id)
  def empty: Data978 = Data978(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data978 =
    Data978(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data978] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
