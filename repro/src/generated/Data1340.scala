package generated

final case class Data1340(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1340 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1340 = copy(value = value * k)
  def addTag(t: String): Data1340 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1340 = copy(meta = meta.updated(k, v))
  def merge(other: Data1340): Data1340 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1340 {
  given Ordering[Data1340] = Ordering.by(_.id)
  def empty: Data1340 = Data1340(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1340 =
    Data1340(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1340] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
