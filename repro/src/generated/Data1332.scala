package generated

final case class Data1332(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1332 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1332 = copy(value = value * k)
  def addTag(t: String): Data1332 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1332 = copy(meta = meta.updated(k, v))
  def merge(other: Data1332): Data1332 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1332 {
  given Ordering[Data1332] = Ordering.by(_.id)
  def empty: Data1332 = Data1332(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1332 =
    Data1332(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1332] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
