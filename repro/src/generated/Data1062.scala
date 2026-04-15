package generated

final case class Data1062(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1062 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1062 = copy(value = value * k)
  def addTag(t: String): Data1062 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1062 = copy(meta = meta.updated(k, v))
  def merge(other: Data1062): Data1062 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1062 {
  given Ordering[Data1062] = Ordering.by(_.id)
  def empty: Data1062 = Data1062(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1062 =
    Data1062(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1062] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
