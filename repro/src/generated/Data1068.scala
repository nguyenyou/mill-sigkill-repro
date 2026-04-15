package generated

final case class Data1068(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1068 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1068 = copy(value = value * k)
  def addTag(t: String): Data1068 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1068 = copy(meta = meta.updated(k, v))
  def merge(other: Data1068): Data1068 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1068 {
  given Ordering[Data1068] = Ordering.by(_.id)
  def empty: Data1068 = Data1068(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1068 =
    Data1068(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1068] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
